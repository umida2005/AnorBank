//package com.example.anorbank.utils.spacers
//
//import com.sudo_pacman.paynet.data.pref.MyShar
//import com.sudo_pacman.paynet.data.source.remote.api.AppApi
//import com.sudo_pacman.paynet.data.source.remote.request.auth.UpdateTokenRequest
//import okhttp3.Authenticator
//import okhttp3.Interceptor
//import okhttp3.Request
//import okhttp3.Response
//import okhttp3.Route
//import javax.inject.Inject
//import javax.inject.Provider
//
//class HeaderInterceptor @Inject constructor(
//    private val api: Provider<AppApi>,
//) : Interceptor {
//    private val pref = MyShar
//
//    private fun refreshToken(chain: Interceptor.Chain, request: Request): Response {
//        val response = api.get().refreshToken(UpdateTokenRequest(pref.getRefreshToken())).execute()
//        if (response.isSuccessful) {
//            val access = response.body()?.access_token
//            val refresh = response.body()?.refresh_token
//            pref.setRefreshToken(refresh.toString())
//            pref.setAccessToken(access.toString())
//
//            val newRequest = request.newBuilder().removeHeader("Authorization")
//                .addHeader("Authorization", "Bearer $access").build()
//            return chain.proceed(newRequest)
//        }
//        return chain.proceed(request)
//    }
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val token = pref.getAccessToken()
//        val request =
//            chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
//
//        val response = chain.proceed(request)
//
//        if (response.code == 401) {
//            response.close()
//            return refreshToken(chain, request)
//        }
//        return response
//    }
//}