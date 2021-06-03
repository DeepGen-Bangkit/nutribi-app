package com.bangkit.nutribiapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRecipeItemResponse(
    val id: Int? = null,
    val step: List<Step>? = null,
    val ingredients: List<Ingredient>? = null,
    val image: String? = null,
    val name: String? = null,
    val estimated: String? = null,
    val protein: String? = null,
    val lemak: String? = null,
    val karbo: String? = null,
    val kcal_total: Int? = null,
    val protein_total: Double? = null,
    val protein_presentase: Double? = null,
    val lemak_total: Double? = null,
    val lemak_presentase: Double? = null,
    val karbo_total: Double? = null,
    val karbo_presentase: Double? = null
) : Parcelable

@Parcelize
data class FoodRecipe(
    val id: Int? = null,
    val name: String? = null,
    val kcal: Int? = null,
    val nutrition: List<NutritionRecipe>? = null,
    val image: String? = null
) : Parcelable

@Parcelize
data class Step(
    val step: String? = null
) : Parcelable

@Parcelize
data class NutritionRecipe(
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
) : Parcelable

@Parcelize
data class Ingredient(
    val id: Int? = null,
    val food: List<FoodRecipe>? = null,
    val count: Double? = null
) : Parcelable