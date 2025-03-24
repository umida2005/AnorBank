package com.example.anorbank.presentation.main.home.components

fun moneyFormat(value: String): String {
    var newStr = ""
    newStr += if (value.length < 4) {
        value
    } else if (value.length in 4..6) {
        val index = value.length - 3
        value.substring(0, index) + " " + value.substring(index)
    } else if (value.length in 7..9) {
        val indexF = value.length - 6
        val indexS = value.length - 3
        value.substring(0, indexF) + " " + value.substring(indexF, indexS) + " " + value.substring(
            indexS
        )
    } else {
        "∞"
    }
    return newStr
}