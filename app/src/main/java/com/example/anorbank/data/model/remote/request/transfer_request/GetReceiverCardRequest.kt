package com.example.anorbank.data.model.remote.request.transfer_request

import com.google.gson.annotations.SerializedName

data class GetReceiverCardRequest (
    @SerializedName ("pan") val pan: String
)