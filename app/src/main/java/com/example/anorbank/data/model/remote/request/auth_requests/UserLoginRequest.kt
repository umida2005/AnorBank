package com.example.anorbank.data.model.remote.request.auth_requests

data class UserLoginRequest(
    val phone: String,
    val password: String
)
