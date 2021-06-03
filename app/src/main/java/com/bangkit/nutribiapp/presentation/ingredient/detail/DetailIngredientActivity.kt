package com.bangkit.nutribiapp.presentation.ingredient.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.nutribiapp.databinding.ActivityDetailIngredientBinding
import com.bangkit.nutribiapp.model.Nutrition
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse

class DetailIngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailIngredientBinding
    private lateinit var adapter: DetailIngredientAdapter

    companion object {
        const val EXTRA_INGREDIENT = "extra_ingredient"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DetailIngredientAdapter()

        val ingredient = intent.getParcelableExtra<SearchIngredientItemResponse>(EXTRA_INGREDIENT)

        if (ingredient != null) {
            setupUI(ingredient)
        }


    }

    private fun setupUI(ingredient: SearchIngredientItemResponse) {

        with(binding) {

            tvName.text = ingredient.name
            tvGram.text = ingredient.gram.toString()
            tvCal.text = ingredient.kcal.toString()

            if (ingredient.nutrition != null) {

            }
        }
    }




}