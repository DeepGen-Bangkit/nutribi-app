package com.bangkit.nutribiapp.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.nutribiapp.databinding.ActivityHomeBinding
import com.bangkit.nutribiapp.presentation.detail.RecipeViewModel
import com.bangkit.nutribiapp.presentation.detail.adapter.RecipeAdapter
import com.bangkit.nutribiapp.presentation.ingredient.IngredientActivity
import com.bangkit.nutribiapp.presentation.objectdetection.ObjectDetection
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: RecipeViewModel by viewModel()

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter()
    }


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

        initObserver()

        initRecyclerView()

    }

    private fun initObserver() {
        val ingredient = ""

        viewModel.getSearchRecipe(ingredient)
        viewModel.searchRecipeItemResponse.observe(this) {
            recipeAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {

        with(binding.rvResep) {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = recipeAdapter
        }

    }
}