package com.bangkit.nutribiapp.network

import com.bangkit.nutribiapp.model.LoginRequest
import com.bangkit.nutribiapp.model.LoginResponse
import com.bangkit.nutribiapp.model.NutritionDetailRequest
import com.bangkit.nutribiapp.model.NutritionDetailResponse
import com.bangkit.nutribiapp.model.RegisterRequest
import com.bangkit.nutribiapp.model.RegisterResponse
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("users/login/")
    suspend fun postLogin(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @POST("users/register/")
    suspend fun postRegister(
        @Body registerRequest: RegisterRequest
    ): Response<RegisterResponse>

    @GET("food/bahan/")
    suspend fun getSearchIngredient(
        @Query("name") name: String,
        @Query("count") count: Boolean
    ): Response<List<SearchIngredientItemResponse>>

    @GET("food/recipe/")
    suspend fun getSearchRecipe(
        @Query("ingredients") ingredients: String,
        @Query("count") count: Boolean
    ): Response<List<SearchRecipeItemResponse>>

    @POST("food/nutrition-detail/")
    suspend fun postNutritionDetail(
        @Body nutritionDetailRequest: List<NutritionDetailRequest>
    ): Response<NutritionDetailResponse>

}