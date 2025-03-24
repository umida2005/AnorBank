package com.example.anorbank.data.model.remote.response.transfer_response

import com.google.gson.annotations.SerializedName

data class TransferVerifyResponse(
    @SerializedName("message") val message: String
)