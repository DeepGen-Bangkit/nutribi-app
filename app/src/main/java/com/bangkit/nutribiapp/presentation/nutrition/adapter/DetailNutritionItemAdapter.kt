package com.bangkit.nutribiapp.presentation.nutrition.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.Food
import com.bangkit.nutribiapp.presentation.ingredient.detail.DetailIngredientActivity
import com.bangkit.nutribiapp.utils.GlideApp
import kotlinx.android.synthetic.main.items_detail_ingredient.view.img_ingredient
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_fat
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_karbo
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_name
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_protein
import java.util.ArrayList

class DetailNutritionItemAdapter : RecyclerView.Adapter<DetailNutritionItemAdapter.ListViewHolder>() {

    var listData = ArrayList<Food>()

    fun setData(newListData: List<Food>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_detail_ingredient, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: Food) {
            with(itemView) {
                tv_name.text = data.name ?: ""
                tv_fat.text = "Lemak " + (data.nutrition?.lemak ?: "-")
                tv_karbo.text = "Karbohidrat " + (data.nutrition?.carbo ?: "-")
                tv_protein.text = "Protein " + (data.nutrition?.protein ?: "-")

                Log.d("TAG", "bind: " + data.image?.takeLast(data.image.length - 10))

                if("/https%3A/" == data.image?.take(10)){
                    Log.d("TAG", "bind: true")
                    GlideApp.with(this).load("https://"+data.image.takeLast(data.image.length - 10)).into(img_ingredient)
//                    GlideApp.with(this).load("https://storage.googleapis.com/svg-image/seafood.svg").into(img_ingredient)
                } else {
                    Log.d("TAG", "bind: false")
                    GlideApp.with(this).load(data.image).into(img_ingredient)
                }

                setOnClickListener{
                    DetailIngredientActivity.start(context, data)
                }
            }
        }
    }
}