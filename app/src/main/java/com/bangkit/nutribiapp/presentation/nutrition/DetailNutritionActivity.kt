package com.bangkit.nutribiapp.presentation.nutrition

import android.R.string
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.databinding.ActivityDetailNutritionBinding
import com.bangkit.nutribiapp.model.NutritionDetailRequest
import com.bangkit.nutribiapp.presentation.ingredient.IngredientViewModel
import com.bangkit.nutribiapp.presentation.nutrition.adapter.DetailNutritionItemAdapter
import com.bangkit.nutribiapp.utils.DataObject.searchRecipeResponse
import kotlinx.android.synthetic.main.activity_result_scanner.rv_ingredients
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.NumberFormat

class DetailNutritionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNutritionBinding

    private val ingredientViewModel: IngredientViewModel by viewModel()

    private val detailNutritionAdapter: DetailNutritionItemAdapter by lazy {
        DetailNutritionItemAdapter()
    }

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

        initRecyclerView()

        val nutritionDetailRequest = mutableListOf<NutritionDetailRequest>()

        searchRecipeResponse.forEach{
            nutritionDetailRequest.add(
                NutritionDetailRequest(
                    name = it.name,
                    count = it.gram
                )
            )
        }

        ingredientViewModel.postNutritionDetail(nutritionDetailRequest)
        ingredientViewModel.nutritionDetailResponse.observe(this){
            Log.d("TAG", "onCreate: " + it)

            val format: NumberFormat = NumberFormat.getInstance()
            val valueCarbo: Number = format.parse(it.carbo_presentase)
            val valueProtein: Number = format.parse(it.protein_presentase)
            val valueFat: Number = format.parse(it.lemak_presentase)

            with(binding){
                tvKcal.text = it.kcal_total + " kcal"
                tvFat.text = it.lemak_total
                tvProtein.text = it.protein_total
                tvKarbo.text = it.carbo_total

                progressFat.progress = valueFat.toInt()
                progressKarbo.progress = valueCarbo.toInt()
                progressProtein.progress = valueProtein.toInt()
            }

            detailNutritionAdapter.setData(it.food)
        }
    }

    private fun initRecyclerView() {
        rv_ingredients.apply {
            layoutManager = LinearLayoutManager(this@DetailNutritionActivity)
            adapter = detailNutritionAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}