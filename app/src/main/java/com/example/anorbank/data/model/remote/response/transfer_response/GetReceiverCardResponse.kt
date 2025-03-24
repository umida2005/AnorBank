package com.example.anorbank.data.model.remote.response.transfer_response

import com.google.gson.annotations.SerializedName

data class GetReceiverCardResponse(
    @SerializedName ("pan") val pan: String
)
