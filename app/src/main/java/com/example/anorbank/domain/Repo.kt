package com.example.anorbank.domain

import androidx.paging.PagingData
import com.example.anorbank.data.model.remote.StartScreenEnum
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
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.data.model.remote.response.historyResponse.TransferHistory
import com.example.anorbank.data.model.remote.response.transfer_response.GetReceiverCardResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferVerifyResponse
import com.example.anorbank.data.source.local.db.RequestTokenAuth
import kotlinx.coroutines.flow.Flow


interface Repo {

    fun startScreen(): StartScreenEnum
    fun saveSelectedLanguage(lang: String)
    fun registration(data: UserRegisterRequest): Flow<Result<UserRegisterResponse>>
    fun login(data: UserLoginRequest): Flow<Result<UserLoginResponse>>
    fun saveToken (token: String)
    fun otpVerifySignUp(otp: OtpRequest) : Flow<Result<OtpResponseToken>>
    fun otpVerifySignIn(otp: OtpRequest) : Flow<Result<OtpResponseToken>>
    fun updateToken(updateToken: RequestTokenAuth) : Flow<Result<OtpResponseToken>>


    //card add

    fun addCard(cardData: AddCardRequest) : Flow<Result<String>>
    fun getAllCards(): Flow<Result<List<GetCardResponse>>>


    //transfer
    fun getReceiverPan( pan: GetReceiverCardRequest): Flow<Result<GetReceiverCardResponse>>
    fun transfer(transferData:TransferRequest) : Flow<Result<TransferResponse>>

    fun transferVerify(trVerify: TransferVerifyRequest): Flow<Result<TransferVerifyResponse>>

    //fun getTransferHistory(): Flow<Result<TransferHistory>>
    fun getTransferHistory(size:Int,currentPage:Int):Flow<PagingData<Child>>

    //card local db fun

//    fun getCardList(successBlock:(List<CardUIData>) ->Unit)
//    fun addCard(pan: String, expiredYear: String, expiredMonth: String, name: String)
}