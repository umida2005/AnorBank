package com.example.anorbank.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.anorbank.data.model.remote.interceptor.HeaderInterceptor
import com.example.anorbank.data.model.remote.interceptor.TokenAuthenticator
import com.example.anorbank.data.source.remote.MyApi
import com.example.anorbank.utils.NetworkStatusValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Suppress("UNREACHABLE_CODE")
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
//    @[Provides Singleton]
//     fun provideGson():Gson = Gson




    @[Provides Singleton]
    fun provideOkHttp(
        @ApplicationContext context: Context,
        authInterceptor: TokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(ChuckerInterceptor(context = context))
            .authenticator(authInterceptor)
            .build()
    }
//    @[Provides Singleton]
//    fun provideOkHttp(
//        @ApplicationContext context: Context,
//        networkStatusValidator: NetworkStatusValidator,
//        tokenAuth:TokenAuthenticator,
////       authInterceptor: AuthInterceptor,
//      headerInterceptor: HeaderInterceptor
//    ): OkHttpClient {
//        val cacheSize = (50 * 1024 * 1024).toLong()  // 50 MB
//        val cache = Cache(context.cacheDir, cacheSize)
//        val maxStale = 60 * 60 * 24 * 30
//
//
//        return OkHttpClient.Builder()
////          .addInterceptor(headerInterceptor)
////            .addInterceptor(authInterceptor)
//            .addInterceptor(headerInterceptor)
//            .authenticator(tokenAuth)
//            .addInterceptor(ChuckerInterceptor(context))
//
//            .readTimeout(30, TimeUnit.SECONDS)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .cache(cache).build()
//        return OkHttpClient.Builder()
//            .addInterceptor(ChuckerInterceptor(context))
//            .addInterceptor { chain ->
//                if (!networkStatusValidator.hasNetwork) {
//                    val newRequest = chain.request()
//                        .newBuilder()
//                        .header(
//                            "Cache-Control",
//                            "public, only-if-cached, max-stale=" + maxStale
//                        )
//                        .removeHeader("Pragma").build()
//                    chain.proceed(newRequest)
//                } else chain.proceed(chain.request())
//            }
//            .readTimeout(30, TimeUnit.SECONDS)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .cache(cache).build()
//    }


    @[Provides Singleton]
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://195.158.16.140/mobile-bank/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides()
    @Singleton
    fun provideContactApi(retrofit: Retrofit): MyApi =
        retrofit.create(MyApi::class.java)

}