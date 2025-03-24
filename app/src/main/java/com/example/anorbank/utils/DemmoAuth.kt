//package com.example.anorbank.utils
//
//import kotlinx.coroutines.runBlocking
//import okhttp3.Authenticator
//import okhttp3.Request
//import okhttp3.Response
//import okhttp3.Route
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import uz.gita.mobilebanking.data.local.MyPreferences
//import uz.gita.mobilebanking.data.model.request.RefreshTokenRequest
//import uz.gita.mobilebanking.data.remote.api.RefreshApi
//import javax.inject.Inject
//
//class TokenAuthenticator @Inject constructor(
//private val localStorage:MyPreferences
//): Authenticator {
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("http://195.158.16.140/mobile-bank/v1/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    private val refreshApi = retrofit.create(RefreshApi::class.java)
//    override fun authenticate(route: Route?, response: Response): Request? {
//        return runBlocking {
//            val responseRefresh = refreshApi.refreshToken(RefreshTokenRequest(localStorage.refreshToken))
//            if (responseRefresh.isSuccessful && responseRefresh.code() == 200) {
//                val data = responseRefresh.body()!!
//                localStorage.accessToken = data.accessToken
//                localStorage.refreshToken = data.refreshToken
//
//                return@runBlocking response.request.newBuilder()
//                    .removeHeader("Authorization")
//                    .header("Authorization", "Bearer ${localStorage.accessToken}")
//                    .build()
//            } else null
//        }
//    }
//
//}