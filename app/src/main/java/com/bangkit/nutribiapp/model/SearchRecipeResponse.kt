package com.bangkit.nutribiapp.model

data class SearchRecipeItemResponse(
    val id: Int? = null,
    val step: List<Step>? = null,
    val ingredients: List<Ingredient>? = null,
    val name: String? = null
)

data class Step(
    val step: String? = null
)

data class Ingredient(
    val food__name: String? = null,
    val count: Double? = null,
    val desc: String? = null
)