package com.bangkit.nutribiapp.network

import com.bangkit.nutribiapp.model.LoginRequest
import com.bangkit.nutribiapp.model.LoginResponse
import com.bangkit.nutribiapp.model.RegisterRequest
import com.bangkit.nutribiapp.model.RegisterResponse
import retrofit2.Response

class Repository(private val apiService: ApiService) {

    suspend fun postLogin(
        loginRequest: LoginRequest
    ): Response<LoginResponse> {
        return apiService.postLogin(loginRequest)
    }

    suspend fun postRegister(
        registerRequest: RegisterRequest
    ): Response<RegisterResponse> {
        return apiService.postRegister(registerRequest)
    }
}