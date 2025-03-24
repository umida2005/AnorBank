//package com.example.anorbank.utils
//
//import android.content.Context
//import com.chuckerteam.chucker.api.ChuckerInterceptor
//import com.google.gson.Gson
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import uz.gita.mobilebanking.data.local.MyPreferences
//import uz.gita.mobilebanking.data.remote.api.AuthApi
//import uz.gita.mobilebanking.utils.PublicNetwork
//import uz.gita.mobilebanking.utils.TokenAuthenticator
//import javax.inject.Named
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class NetworkModule {
//    private val baseUrl = "http://195.158.16.140/mobile-bank/v1/"
//
//    @[Provides Singleton Named("AuthenticationClient")]
//    fun provideOkHttpClient(
//        @ApplicationContext context: Context,
//        authenticator: TokenAuthenticator,
//        localStorage:MyPreferences
//    ): OkHttpClient =
//        OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(context).build()).addInterceptor { chain ->
//            val request = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer ${localStorage.accessToken}")
//                .build()
//            return@addInterceptor chain.proceed(request)
//        }
//            .authenticator(authenticator).build()
//
//    @[Provides Singleton Named("PublicClient")]
//    fun provideOkHttpClientPublic(@ApplicationContext context: Context): OkHttpClient =
//        OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(context).build()).build()
//
////    @[Provides Singleton Named("PublicRetrofit")]
//    fun provideRetrofitPublic(@Named("PublicClient") client: OkHttpClient): Retrofit = Retrofit
//        .Builder()
//        .baseUrl(baseUrl)
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    @[Provides Singleton Named("AuthenticationaRetrofit")]
//    fun provideRetrofit(@Named("AuthenticationClient") client: OkHttpClient): Retrofit = Retrofit
//        .Builder()
//        .baseUrl(baseUrl)
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    @[Provides Singleton]
//    fun provideAuthApi(@Named("PublicRetrofit") retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
//
//
//    @[Provides Singleton]
//    fun getGson(): Gson = Gson()
//}