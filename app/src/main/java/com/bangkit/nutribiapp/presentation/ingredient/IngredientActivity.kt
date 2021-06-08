package com.bangkit.nutribiapp.presentation.ingredient

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.detail.SelectedFoodActivity
import com.bangkit.nutribiapp.presentation.ingredient.adapter.IngredientAdapter
import com.bangkit.nutribiapp.utils.DataObject
import kotlinx.android.synthetic.main.activity_ingredient.btnClear
import kotlinx.android.synthetic.main.activity_ingredient.btnNextIngredient
import kotlinx.android.synthetic.main.activity_ingredient.rv_ingredients
import kotlinx.android.synthetic.main.activity_ingredient.searchView
import org.koin.android.viewmodel.ext.android.viewModel

class IngredientActivity : AppCompatActivity() {

    private val ingredientAdapter: IngredientAdapter by lazy {
        IngredientAdapter()
    }

    private val ingredientViewModel: IngredientViewModel by viewModel()

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
        initObserver()
        initAction()

        // Testing
//        setDataDummy()
    }

    private fun initSearch() {
        searchView.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
//                ingredientViewModel.getSearchIngredient(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ingredientViewModel.getSearchIngredient(query)
                return false
            }
        })
    }

    private fun initObserver() {
        ingredientViewModel.getSearchIngredient("")
        ingredientViewModel.searchIngredientItemResponse.observe(this){
            ingredientAdapter.setData(it)
        }
    }

    private fun initAction() {
        btnNextIngredient.setOnClickListener {
            SelectedFoodActivity.start(this)
        }

        initSearch()

        btnClear.setOnClickListener{
            DataObject.searchRecipeResponse.clear()
        }
    }

//    private fun setDataDummy() {
//        var list: ArrayList<IngredientResponse> = arrayListOf()
//
//        for (i in 0..11) {
//            list.add(
//                IngredientResponse(
//                    name = "Beras",
//                    kcalPerGram = "120Kcal/100gram"
//                )
//            )
//        }
//        ingredientAdapter.setData(list)
//    }

    private fun initRecyclerView() {
        rv_ingredients.apply {
            layoutManager = LinearLayoutManager(this@IngredientActivity)
            adapter = ingredientAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        DataObject.searchRecipeResponse.clear()
    }
}