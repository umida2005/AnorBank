package com.example.anorbank.data.source.remote

import com.example.anorbank.data.model.remote.response.token_response.OtpResponseToken
import retrofit2.Response

interface AuthApi {
     fun updateToken(refreshToken: String): Response<OtpResponseToken>
}