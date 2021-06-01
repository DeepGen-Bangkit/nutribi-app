package com.bangkit.nutribiapp.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.network.Repository
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: Repository) : ViewModel() {

    var searchRecipeItemResponse: MutableLiveData<List<SearchRecipeItemResponse>> = MutableLiveData()

    fun getSearchRecipe(ingredients: String) {
        viewModelScope.launch {
            try {
                val response = repository.getSearchRecipe(ingredients)
                if (response.isSuccessful) {
                    searchRecipeItemResponse.value = response.body()
                }
            } catch (e: Exception) {
            }
        }
    }
}