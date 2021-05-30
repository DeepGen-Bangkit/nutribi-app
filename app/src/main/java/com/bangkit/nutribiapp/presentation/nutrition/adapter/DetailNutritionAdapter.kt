package com.bangkit.nutribiapp.presentation.nutrition.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.databinding.ItemsDetailIngredientBinding
import com.bangkit.nutribiapp.model.IngredientResponse

class DetailNutritionAdapter : RecyclerView.Adapter<DetailNutritionAdapter.ViewHolder>() {

    private val listIngredients = ArrayList<IngredientResponse>()

    fun setIngredients(ingredients: List<IngredientResponse>) {
        listIngredients.clear()
        listIngredients.addAll(ingredients)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsDetailIngredientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listIngredients[position])
    }

    override fun getItemCount(): Int = listIngredients.size

    class ViewHolder(private val binding: ItemsDetailIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: IngredientResponse) {

            with(binding) {

            }

        }
    }
}
