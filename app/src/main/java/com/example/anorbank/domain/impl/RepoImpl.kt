package com.example.anorbank.domain.impl

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.anorbank.data.model.remote.StartScreenEnum
import com.example.anorbank.data.model.remote.request.auth_requests.UserLoginRequest
import com.example.anorbank.data.model.remote.request.auth_requests.UserRegisterRequest
import com.example.anorbank.data.model.remote.request.card_requests.AddCardRequest
import com.example.anorbank.data.model.remote.request.token_requests.OtpRequest
import com.example.anorbank.data.model.remote.request.transfer_request.GetReceiverCardRequest
import com.example.anorbank.data.model.remote.request.transfer_request.TransferRequest
import com.example.anorbank.data.model.remote.request.transfer_request.TransferVerifyRequest
import com.example.anorbank.data.model.remote.response.auth_response.UserLoginResponse
import com.example.anorbank.data.model.remote.response.auth_response.UserRegisterResponse
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.data.model.remote.response.historyResponse.TransferHistory
import com.example.anorbank.data.model.remote.response.token_response.OtpResponseToken
import com.example.anorbank.data.model.remote.response.transfer_response.GetReceiverCardResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferResponse
import com.example.anorbank.data.model.remote.response.transfer_response.TransferVerifyResponse
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.data.source.local.db.RequestTokenAuth
import com.example.anorbank.data.source.remote.MyApi
import com.example.anorbank.domain.Repo
import com.example.anorbank.domain.TestPaginationSource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepoImpl @Inject constructor(
    private val shared: MyPreference, private val api: MyApi
) : Repo {


    override fun startScreen(): StartScreenEnum {
        return when (shared.getToken()) {
            "LOGIN" -> StartScreenEnum.Login
            else -> StartScreenEnum.Main
        }
    }

    override fun saveSelectedLanguage(lang: String) {

    }

    override fun registration(data: UserRegisterRequest): Flow<Result<UserRegisterResponse>> =
        callbackFlow {
            val response = api.registerUser(data)
            if (response.isSuccessful && response.body() != null) {
                val comingToken = response.body()!!.token
                saveToken(comingToken)
                trySend(Result.success(response.body()!!))
            } else trySend(Result.failure(Exception("Fail, your data couldn't registered!")))

            awaitClose()
        }

    val list = listOf<String>().asFlow()
//    override fun registration(data: UserRegisterRequest): Flow<Result<UserRegisterResponse>> =
//        flow {
//            val response = api.registerUser(data)
//            if (response.isSuccessful && response.body() != null) {
//                val comingToken = response.body()!!.token
//                saveToken(comingToken)
//                emit(Result.success(response.body()!!))
//            } else emit(Result.failure(Exception("Fail, your data couldn't registered!")))
//        }


    override fun login(data: UserLoginRequest): Flow<Result<UserLoginResponse>> =
        callbackFlow {
            val response = api.login(data)
            if (response.isSuccessful && response.body() != null) {
                val comingToken = response.body()!!.token
                saveToken(comingToken)
                trySend(Result.success(response.body()!!))
            } else trySend(Result.failure(Exception("Failed, this user has not been registered")))

            awaitClose()
        }

    override fun saveToken(token: String) {
        shared.saveToken(token)
    }

    override fun otpVerifySignUp(otp: OtpRequest): Flow<Result<OtpResponseToken>> =
        callbackFlow {
            val response = api.otpVerifySignUp(otp)
            if (response.isSuccessful && response.body() != null) {
                val access = response.body()!!.accessToken
                val refresh = response.body()!!.refreshToken
                shared.saveAccessToken(access)
                shared.saveRefreshToken(refresh)
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Something went wrong!")))
            }
            awaitClose()
        }

    override fun otpVerifySignIn(otp: OtpRequest): Flow<Result<OtpResponseToken>> = callbackFlow {
        val response = api.otpVerifySignIn(otp)
        if (response.isSuccessful && response.body() != null) {
            val access = response.body()!!.accessToken
            val refresh = response.body()!!.refreshToken
            shared.saveAccessToken(access)
            shared.saveRefreshToken(refresh)
            trySend(Result.success(response.body()!!))
        } else {
            trySend(Result.failure(Exception("Something went wrong!")))
        }
        awaitClose()
    }

    override fun updateToken(updateToken: RequestTokenAuth): Flow<Result<OtpResponseToken>> =
        callbackFlow {
            val refreshFromShared = shared.getRefreshToken()
            updateToken.token = refreshFromShared
            val response = api.updateToken(updateToken)
            if (response.isSuccessful && response.body() != null) {
                val access = response.body()!!.accessToken
                val refresh = response.body()!!.refreshToken
                shared.saveAccessToken(access)
                shared.saveRefreshToken(refresh)
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Something, went wrong!")))
            }
            awaitClose()
        }

    override fun addCard(cardData: AddCardRequest): Flow<Result<String>> =
        callbackFlow {
            val response = api.addCard(cardData)
            if (response.isSuccessful && response.body() != null) {
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Invalid card")))
            }
            awaitClose()


        }

    override fun getAllCards(): Flow<Result<List<GetCardResponse>>> =
        callbackFlow {
            val response = api.getAllCards()
            if (response.isSuccessful && response.body() != null) {
                Log.d("ZZZ", "repository: ${response.body()} ")
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Invalid data")))
            }
            awaitClose()
        }

    override fun getReceiverPan(pan: GetReceiverCardRequest): Flow<Result<GetReceiverCardResponse>> =
        callbackFlow {
            val response = api.getReceiverPan(pan)
            if (response.isSuccessful && response.body() != null) {
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Invalid Data")))
            }
            awaitClose()
        }

    override fun transfer(transferData: TransferRequest): Flow<Result<TransferResponse>> =
        callbackFlow {
            val response = api.transfer(transferData)
            shared.saveTransferToken(response.body()!!.token)
            if (response.isSuccessful && response.body() != null) {
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Invalid data")))
            }
            awaitClose()
        }

    override fun transferVerify(trVerify: TransferVerifyRequest): Flow<Result<TransferVerifyResponse>> =
        callbackFlow {
            val response = api.transferVerify(trVerify)
            if (response.isSuccessful && response.body() != null) {
                trySend(Result.success(response.body()!!))
            } else {
                trySend(Result.failure(Exception("Invalid data")))
            }
            awaitClose()
        }

    override fun getTransferHistory(size: Int, currentPage: Int): Flow<PagingData<Child>> =
        Pager(
            config = PagingConfig(size), pagingSourceFactory = { TestPaginationSource(api = api) },
        ).flow


//    override fun getTransferHistory(): Flow<Result<TransferHistory>> = callbackFlow {
//        val response = api.getHistory(10, 1)
//        if (response.isSuccessful && response.body() != null) {
//            trySend(Result.success(response.body()!!))
//        } else {
//            trySend(Result.failure(Exception("No history")))
//        }
//        awaitClose()
//    }
}