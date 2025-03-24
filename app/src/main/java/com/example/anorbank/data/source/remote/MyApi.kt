package com.example.anorbank.data.source.remote

import com.example.anorbank.data.model.remote.interceptor.Cacheable
import com.example.anorbank.data.model.remote.request.token_requests.OtpRequest
import com.example.anorbank.data.model.remote.request.auth_requests.UserLoginRequest
import com.example.anorbank.data.model.remote.request.auth_requests.UserRegisterRequest
import com.example.anorbank.data.model.remote.request.card_requests.AddCardRequest
import com.example.anorbank.data.model.remote.request.transfer_request.GetReceiverCardRequest
import com.example.anorbank.data.model.remote.request.transfer_request.TransferRequest
import com.example.anorbank.data.model.remote.request.transfer_request.TransferVerifyRequest
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.model.remote.response.token_response.OtpResponseToken
import com.example.anorbank.data.model.remote.response.auth_response.UserLoginResponse
import com.example.anorbank.data.model.remote.response.auth_response.UserRegisterResponse
import com.example.anorbank.data.model.remote.response.historyResponse.TransferHistory
import com.example.anorbank.data.model.remote.response.transfer_response.GetReceiverCardResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferVerifyResponse
import com.example.anorbank.data.source.local.db.RequestTokenAuth
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MyApi {

    //AUTHENTICATION


    @POST("v1/auth/update-token")
    suspend fun updateToken(@Body refreshToken: RequestTokenAuth): Response<OtpResponseToken>
    @POST("v1/auth/sign-up")
    suspend fun registerUser(@Body userData: UserRegisterRequest): Response<UserRegisterResponse>

    @POST("v1/auth/sign-in")
    suspend fun login(@Body userData: UserLoginRequest): Response<UserLoginResponse>

    @POST("v1/auth/sign-up/verify")
    suspend fun otpVerifySignUp(@Body otpData: OtpRequest): Response<OtpResponseToken>

    @POST("v1/auth/sign-in/verify")
    suspend fun otpVerifySignIn(@Body otpData: OtpRequest): Response<OtpResponseToken>


    @POST("v1/auth/sign-up/resend")
    suspend fun upResend(@Body expiredToken: String): Response<String>

    @POST("v1/auth/sign-in/resend")
    suspend fun inResend(@Body expiredToken: String): Response<String>

    @POST("v1/auth/sign-out")
    suspend fun signOut(): Response<String>


    //CARD
@Cacheable
    @POST("v1/card")
    suspend fun addCard(@Body cardData: AddCardRequest) : Response<String>



    @GET("v1/card")
    @Cacheable
    suspend fun getAllCards():Response<List<GetCardResponse>>



    //Transfer
   @Cacheable
    @POST("v1/transfer/card-owner")
    suspend fun getReceiverPan(@Body cardPan: GetReceiverCardRequest): Response<GetReceiverCardResponse>

    @POST("v1/transfer/transfer")
    suspend fun transfer(@Body transferData: TransferRequest) : Response<TransferResponse>

    @POST("v1/transfer/transfer/verify")
    suspend fun transferVerify(@Body transferVerify: TransferVerifyRequest): Response<TransferVerifyResponse>
@Cacheable
    @GET("v1/transfer/history")
    suspend fun getHistory(@Query("size") size: Int, @Query("current-page")currentPage: Int) : Response<TransferHistory>

}