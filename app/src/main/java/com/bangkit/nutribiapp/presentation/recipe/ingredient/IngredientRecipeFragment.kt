package com.bangkit.nutribiapp.presentation.recipe.ingredient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.presentation.recipe.ingredient.adapter.IngredientRecipeAdapter
import kotlinx.android.synthetic.main.fragment_ingredient_recipe.rv_ingredients

class IngredientRecipeFragment(val searchRecipeItemResponse: SearchRecipeItemResponse) : Fragment() {

    private val ingredientRecipeAdapter: IngredientRecipeAdapter by lazy {
        IngredientRecipeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        ingredientRecipeAdapter.setData(searchRecipeItemResponse.ingredients)
    }

    private fun initRecyclerView() {
        rv_ingredients.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ingredientRecipeAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}