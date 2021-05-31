package com.bangkit.nutribiapp.presentation.ingredient

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.IngredientResponse
import com.bangkit.nutribiapp.presentation.detail.SelectedFoodActivity
import com.bangkit.nutribiapp.presentation.ingredient.adapter.IngredientAdapter
import kotlinx.android.synthetic.main.activity_ingredient.btnNextIngredient
import kotlinx.android.synthetic.main.activity_ingredient.rv_ingredients

class IngredientActivity : AppCompatActivity() {

    private val ingredientAdapter: IngredientAdapter by lazy {
        IngredientAdapter()
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, IngredientActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient)

        initRecyclerView()
        initAction()

        // Testing
        setDataDummy()
    }

    private fun initAction() {
        btnNextIngredient.setOnClickListener{
            SelectedFoodActivity.start(this)
        }
    }

    private fun setDataDummy() {
        var list : ArrayList<IngredientResponse> = arrayListOf()

        for (i in 0..11){
            list.add(IngredientResponse(
                name = "Beras",
                kcalPerGram = "120Kcal/100gram"
            ))
        }

        ingredientAdapter.setData(list)
    }

    private fun initRecyclerView() {
        rv_ingredients.apply {
            layoutManager = LinearLayoutManager(this@IngredientActivity)
            adapter = ingredientAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}