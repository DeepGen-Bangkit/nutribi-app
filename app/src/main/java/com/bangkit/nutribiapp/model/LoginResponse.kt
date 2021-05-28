package com.bangkit.nutribiapp.model

data class LoginResponse(
    var token: String? = null,
    var user: User? = null
)

data class User(
    var pk: Int? = null,
    var username: Any? = null,
    var email: String? = null,
    var first_name: String? = null,
    var last_name: String? = null
)