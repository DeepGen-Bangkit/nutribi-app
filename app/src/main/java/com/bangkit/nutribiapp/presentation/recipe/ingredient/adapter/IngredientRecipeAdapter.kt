package com.bangkit.nutribiapp.presentation.recipe.ingredient.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.Ingredient
import com.bangkit.nutribiapp.utils.GlideApp
import kotlinx.android.synthetic.main.items_recipe_ingredients.view.img_ingredient_recipe
import kotlinx.android.synthetic.main.items_recipe_ingredients.view.tv_ingredient
import java.util.ArrayList

class IngredientRecipeAdapter : RecyclerView.Adapter<IngredientRecipeAdapter.ListViewHolder>() {

    private var listData = ArrayList<Ingredient>()

    fun setData(newListData: List<Ingredient>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_recipe_ingredients, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: Ingredient) {
            with(itemView) {
                GlideApp.with(this).load(data.food?.get(0)?.image).into(img_ingredient_recipe)
                tv_ingredient.text = data.count.toString() + " gram " + data.food?.get(0)?.name
            }
        }
    }
}