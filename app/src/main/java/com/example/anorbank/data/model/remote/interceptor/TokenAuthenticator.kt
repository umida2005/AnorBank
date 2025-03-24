package com.example.anorbank.data.model.remote.interceptor

import retrofit2.Invocation


import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.data.source.local.db.RequestTokenAuth
import com.example.anorbank.data.source.remote.MyApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        val invocation: Invocation? = request.tag(Invocation::class.java)

        if (invocation != null) {
            val annotation: Cacheable? =
                invocation.method().getAnnotation(Cacheable::class.java)

            if (annotation != null && annotation.annotationClass.simpleName == "Cacheable" && !hasNetwork(context)) {
                val cacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()

                request = request.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .cacheControl(cacheControl)
                    .build()
            } else {

            }
        }

        return chain.proceed(request)
    }

    private fun hasNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

class OfflineCacheInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!hasNetwork(context)) {
            request = request.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=604800")
                .build()
        }
        return chain.proceed(request)
    }

    private fun hasNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

class TokenAuthenticator @Inject constructor(
    @ApplicationContext context: Context,
    private val shared: MyPreference
) : Authenticator {

    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(context.cacheDir, cacheSize)

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://185.193.17.169:8080/mobile-bank/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient
                .Builder()
                .cache(myCache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (hasNetwork(context))
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    else
                        request.newBuilder().header(
                            "Cache-Control",
                            "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                        ).build()
                    chain.proceed(request)
                }
                .addNetworkInterceptor(OfflineCacheInterceptor(context))
                .addInterceptor(ChuckerInterceptor(context = context))
                .build()
        )
        .build()

    private val refreshApi = retrofit.create(MyApi::class.java)

    @SuppressLint("LogNotTimber")
    override fun authenticate(route: Route?, response: Response): Request? {
        return runBlocking {
            val responseRefresh = refreshApi.updateToken(RequestTokenAuth(shared.getRefreshToken()))

            if (responseRefresh.isSuccessful && responseRefresh.code() == 200) {
                val data = responseRefresh.body()!!
                shared.saveAccessToken(data.accessToken)
                shared.saveRefreshToken(data.refreshToken)
                return@runBlocking response.request.newBuilder()
                    .removeHeader("Authorization")
                    .addHeader(
                        "Authorization",
                        "Bearer ${shared.getAccessToken()}"
                    )
                    .build()
            } else null
        }
    }

    private fun hasNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Cacheable {}


