package com.bangkit.nutribiapp.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.databinding.ActivityHomeBinding
import com.bangkit.nutribiapp.presentation.ingredient.IngredientActivity
import com.bangkit.nutribiapp.presentation.objectdetection.ObjectDetection

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener {
            val intent = Intent(this@HomeActivity, ObjectDetection::class.java)
            startActivity(intent)
        }

        binding.btnSearch.setOnClickListener {
            val intent = Intent(this@HomeActivity, IngredientActivity::class.java)
            startActivity(intent)
        }

    }
}