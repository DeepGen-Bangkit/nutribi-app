package com.bangkit.nutribiapp.presentation.ingredient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.nutribiapp.model.NutritionDetailRequest
import com.bangkit.nutribiapp.model.NutritionDetailResponse
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse
import com.bangkit.nutribiapp.network.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class IngredientViewModel(private val repository: Repository) : ViewModel() {

    var searchIngredientItemResponse: MutableLiveData<List<SearchIngredientItemResponse>> = MutableLiveData()
    var nutritionDetailResponse: MutableLiveData<NutritionDetailResponse> = MutableLiveData()

//    var loginResponse: MutableLiveData<LoginResponse> = MutableLiveData()
//    var registerResponse: MutableLiveData<RegisterResponse> = MutableLiveData()

    fun getSearchIngredient(name: String) {
        viewModelScope.launch {
            try {
                val response = repository.getSearchIngredient(name)
                if (response.isSuccessful) {
                    searchIngredientItemResponse.value = response.body()
                }
            } catch (e: Exception) {
            }
        }
    }

    fun postNutritionDetail(
        nutritionDetailRequest: List<NutritionDetailRequest>
    ) {
        viewModelScope.launch {
            try {
                val response = repository.postNutritionDetail(nutritionDetailRequest)
                if (response.isSuccessful) {
                    nutritionDetailResponse.value = response.body()
                }
            } catch (e: Exception) {
            }
        }
    }

//    fun postLogin(loginRequest: LoginRequest) {
//        viewModelScope.launch {
//            try {
//                val response = repository.postLogin(loginRequest)
//                if (response.isSuccessful) {
//                    loginResponse.value = response.body()
//                }
//            } catch (e: Exception) {
//            }
//        }
//    }
//
//    fun postRegister(registerRequest: RegisterRequest) {
//        viewModelScope.launch {
//            try {
//                val response = repository.postRegister(registerRequest)
//                if (response.isSuccessful) {
//                    registerResponse.value = response.body()
//                }
//            } catch (e: Exception) {
//            }
//        }
//    }
    }