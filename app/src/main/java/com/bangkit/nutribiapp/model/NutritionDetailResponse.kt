package com.bangkit.nutribiapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionDetailResponse(
    val lemak_total: String? = null,
    val protein_total: String? = null,
    val carbo_total: String? = null,
    val food: List<Food>? = null
) : Parcelable

@Parcelize
data class Food(
    val name: String? = null,
    val nutrition: NutritionDetail? = null,
    val kcal: Double? = null,
    val count: Int? = null,
    val image: String? = null
) : Parcelable

@Parcelize
data class NutritionDetail(
    val protein: String? = null,
    val carbo: String? = null,
    val lemak: String? = null,
    val energi: String? = null,
    val air: String? = null,
    val serat: String? = null,
    val abu: String? = null,
    val kalsium: String? = null,
    val fosfor: String? = null,
    val besi: String? = null,
    val natrium: String? = null,
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
