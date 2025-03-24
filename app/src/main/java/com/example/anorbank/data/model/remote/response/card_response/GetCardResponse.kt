package com.example.anorbank.data.model.remote.response.card_response

import com.google.gson.annotations.SerializedName

data class GetCardResponse (
   @SerializedName("id") val id: Int,
   @SerializedName("name")val name: String,
   @SerializedName("amount") val amount : Int,
   @SerializedName("owner")val owner: String,
   @SerializedName("pan") val pan : String,
   @SerializedName("expired-year")val expiredYear: Int,
   @SerializedName("expired-month")val expiredMonth: Int,
   @SerializedName("theme-type")val theme: Int,
   @SerializedName("is-visible")val isVisible: Boolean
)