package com.example.anorbank.data.model.remote.request.transfer_request

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class TransferRequest (
    @SerializedName("type") val type: String,
    @SerializedName("sender-id") val senderId: String,
    @SerializedName("receiver-pan") val receiverPan: String,
    @SerializedName("amount") val amount: Int,
)