package com.bangkit.nutribiapp.di

import com.bangkit.nutribiapp.network.ApiService
import com.bangkit.nutribiapp.network.Repository
import com.bangkit.nutribiapp.presentation.auth.viewmodel.AuthViewModel
import com.bangkit.nutribiapp.presentation.detail.RecipeViewModel
import com.bangkit.nutribiapp.presentation.ingredient.IngredientViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { IngredientViewModel(get()) }
    viewModel { RecipeViewModel(get()) }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://35.221.195.100")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(
            ApiService::class.java
        )
    }
}

val repositoryModule = module {
    single { Repository(get()) }
}