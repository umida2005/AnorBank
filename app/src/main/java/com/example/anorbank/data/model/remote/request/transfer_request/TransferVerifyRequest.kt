package com.example.anorbank.data.model.remote.request.transfer_request

import com.google.gson.annotations.SerializedName

data class TransferVerifyRequest (

    @SerializedName("token") val token: String,
    @SerializedName("code") val code: String

)