package com.bangkit.nutribiapp.model

data class LoginResponse(
    val token: String?,
    val user: User?
)

data class User(
    val pk: Int?,
    val username: Any?,
    val email: String?,
    val first_name: String?,
    val last_name: String?
)