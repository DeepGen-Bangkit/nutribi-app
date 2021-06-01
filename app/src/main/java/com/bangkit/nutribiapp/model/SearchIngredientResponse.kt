package com.bangkit.nutribiapp.model

data class SearchIngredientItemResponse(
    val id: Int? = null,
    val name: String? = null,
    val kcal: Int? = null,
    val nutrition: List<Nutrition>? = null
)

data class Nutrition(
    val protein: Double? = null,
    val carbo: Double? = null,
    val lemak: Double? = null
)