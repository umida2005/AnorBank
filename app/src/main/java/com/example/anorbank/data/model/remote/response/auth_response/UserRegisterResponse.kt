package com.example.anorbank.data.model.remote.response.auth_response

data class UserRegisterResponse (
    val token: String,
    val smsCode: String
)