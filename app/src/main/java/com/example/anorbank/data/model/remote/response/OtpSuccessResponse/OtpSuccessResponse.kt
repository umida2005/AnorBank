package com.example.anorbank.data.model.remote.response.OtpSuccessResponse

import com.google.gson.annotations.SerializedName

data class OtpSuccessResponse(
    @SerializedName ("message")val message: String
)
