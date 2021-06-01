package com.bangkit.nutribiapp.network

import com.bangkit.nutribiapp.model.LoginRequest
import com.bangkit.nutribiapp.model.LoginResponse
import com.bangkit.nutribiapp.model.RegisterRequest
import com.bangkit.nutribiapp.model.RegisterResponse
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

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

    suspend fun getSearchIngredient(
        name: String
    ): Response<List<SearchIngredientItemResponse>> {
        return apiService.getSearchIngredient(name, true)
    }

    suspend fun getSearchRecipe(
        ingredients: String
    ): Response<List<SearchRecipeItemResponse>> {
        return apiService.getSearchRecipe(ingredients, true)
    }
}