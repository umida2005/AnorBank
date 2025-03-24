package com.example.anorbank.data.model.remote.response.token_response

import com.google.gson.annotations.SerializedName

data class OtpResponseToken(
    @SerializedName("refresh-token") val refreshToken: String,
    @SerializedName("access-token") val accessToken: String
)