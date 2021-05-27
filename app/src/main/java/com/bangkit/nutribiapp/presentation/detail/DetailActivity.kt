package com.bangkit.nutribiapp.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.IngredientResponse
import com.bangkit.nutribiapp.model.RecipeResponse
import com.bangkit.nutribiapp.presentation.detail.adapter.RecipeAdapter
import com.bangkit.nutribiapp.presentation.detail.adapter.SelectedIngredientAdapter
import kotlinx.android.synthetic.main.activity_detail.rv_bahan
import kotlinx.android.synthetic.main.activity_detail.rv_resep
import kotlinx.android.synthetic.main.activity_ingredient.rv_ingredients

class DetailActivity : AppCompatActivity() {

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter()
    }

    private val selectedIngredientAdapter: SelectedIngredientAdapter by lazy {
        SelectedIngredientAdapter()
    }


    companion object {

        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initRecyclerView()

        // Testing
        setDataDummy()
    }

    private fun setDataDummy() {
        val list: ArrayList<RecipeResponse> = arrayListOf()

        for (i in 0..11) {
            list.add(
                RecipeResponse(
                    img = "https://www.holidify.com/images/cmsuploads/compressed/jakarta-food-09076010_20190618155553.jpg",
                    name = "Sop Ayam",
                    gram = "120Kcal/100gram"
                )
            )
        }

        recipeAdapter.setData(list)

        /**/

        val listIngredient: ArrayList<IngredientResponse> = arrayListOf()

        for (i in 0..11) {
            listIngredient.add(
                IngredientResponse(
                    name = "Sop Ayam",
                    kcalPerGram = "120Kcal/100gram"
                )
            )
        }

        selectedIngredientAdapter.setData(listIngredient)
    }

    private fun initRecyclerView() {
        rv_bahan.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = selectedIngredientAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }

        rv_resep.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = recipeAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}