package com.example.anorbank.data.model.remote.interceptor

import com.example.anorbank.data.source.local.MyPreference
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val shared: MyPreference):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest =  chain.request()
        val accessToken = shared.getAccessToken()

        if (accessToken.isNotEmpty()){
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $accessToken")
                .build()
            return chain.proceed(newRequest)
        }
        return chain.proceed(originalRequest)
    }
}