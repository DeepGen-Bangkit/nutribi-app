package com.bangkit.nutribiapp.presentation.ingredient.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.databinding.ItemsNutritionBinding
import com.bangkit.nutribiapp.model.IngredientResponse

class DetailIngredientAdapter : RecyclerView.Adapter<DetailIngredientAdapter.ViewHolder>() {

    private val listNutritions = ArrayList<IngredientResponse>()

    fun setNutritions(nutritions: List<IngredientResponse>) {
        listNutritions.clear()
        listNutritions.addAll(nutritions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsNutritionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNutritions[position])
    }

    override fun getItemCount(): Int = listNutritions.size

    class ViewHolder(private val binding: ItemsNutritionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(nutrition: IngredientResponse) {
            with(binding) {
                tvName.text = nutrition.name
                tvScoreNutrition.text = nutrition.kcalPerGram
            }
        }

    }
}