package com.bangkit.nutribiapp.presentation.nutrition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.databinding.ActivityDetailNutritionBinding
import com.bangkit.nutribiapp.presentation.detail.SelectedFoodActivity

class DetailNutritionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNutritionBinding

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, DetailNutritionActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailNutritionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}