package com.example.anorbank.data.model.remote.response.transfer_response

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class TransferResponse (
    @SerializedName("token") val token: String
)