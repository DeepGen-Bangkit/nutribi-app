package com.bangkit.nutribiapp.presentation.auth.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.nutribiapp.model.LoginRequest
import com.bangkit.nutribiapp.model.LoginResponse
import com.bangkit.nutribiapp.model.RegisterRequest
import com.bangkit.nutribiapp.model.RegisterResponse
import com.bangkit.nutribiapp.network.Repository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: Repository) : ViewModel() {

    var loginResponse: MutableLiveData<LoginResponse> = MutableLiveData()
    var registerResponse: MutableLiveData<RegisterResponse> = MutableLiveData()

    fun postLogin(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = repository.postLogin(loginRequest)
                if (response.isSuccessful) {
                    loginResponse.value = response.body()
                }
            } catch (e: Exception) {
            }
        }
    }

    fun postRegister(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            try {
                val response = repository.postRegister(registerRequest)
                if (response.isSuccessful) {
                    registerResponse.value = response.body()
                }
            } catch (e: Exception) {
            }
        }
    }
}