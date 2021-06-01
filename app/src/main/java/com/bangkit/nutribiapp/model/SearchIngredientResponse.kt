package com.bangkit.nutribiapp.model

data class SearchIngredientItemResponse(
    val id: Int? = null,
    val name: String? = null,
    val kcal: Int? = null,
    val nutrition: List<Nutrition>? = null,
    var gram: Int? = 0,
    val image: String? = null
)

data class Nutrition(
    val food: String? = null,
    val carbo: String? = null,
    val protein: String? = null,
    val lemak: String? = null,
    val air: String? = null,
    val energi: String? = null,
    val serat: String? = null,
    val abu: String? = null,
    val kalsium: String? = null,
    val fosfor: String? = null,
    val natrium: String? = null,
    val besi: String? = null,
    val kalium: String? = null,
    val tembaga: String? = null,
    val seng: String? = null,
    val retinol: String? = null,
    val b_kar: String? = null,
    val kar_total: String? = null,
    val thiamin: String? = null,
    val riboflavin: String? = null,
    val niasin: String? = null,
    val vit_c: String? = null
)