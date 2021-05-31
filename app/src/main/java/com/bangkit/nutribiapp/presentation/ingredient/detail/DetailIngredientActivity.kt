package com.bangkit.nutribiapp.presentation.ingredient.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.databinding.ActivityDetailNutritionBinding

class DetailIngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNutritionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailNutritionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DetailIngredientAdapter()

    }
}