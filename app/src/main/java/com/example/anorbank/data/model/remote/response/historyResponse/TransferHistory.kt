package com.example.anorbank.data.model.remote.response.historyResponse

import com.google.gson.annotations.SerializedName

data class TransferHistory(
    @SerializedName("total-element") val totalElement: Int,
    @SerializedName("total-page") val page: Int,
    @SerializedName("current-page") val currentPage: Int,
    @SerializedName("child") val childList: List<Child>

)


data class Child(
    val type: String,
    val from: String,
    val to: String,
    val amount: String,
    val time: String
)
//
//"total-elements": 2,
//"total-pages": 1,
//"current-page": 1,
//"child": [
//{
//    "type": "income",
//    "from": "Muhammadali",
//    "to": "1234567898765420",
//    "amount": 2000,
//    "time": 1671350649653
//},
//{
//    "type": "outcome",
//    "to": "Qudrat",
//    "from": "1234567898765420",
//    "amount": 1000,
//    "time": 1671350605654
//}
//]
//}