package com.example.anorbank.data.model.remote.request.card_requests

import com.google.gson.annotations.SerializedName

data class AddCardRequest(
    @SerializedName("pan") val pan: String,
    @SerializedName("expired-year")  val expiredYear: String,
    @SerializedName("expired-month")val expiredMonth: String,
    @SerializedName("name") val name: String
)
