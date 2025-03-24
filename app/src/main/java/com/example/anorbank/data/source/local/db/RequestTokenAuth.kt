package com.example.anorbank.data.source.local.db

import com.google.gson.annotations.SerializedName

data class RequestTokenAuth(
    @SerializedName ("refresh-token")var token: String)
