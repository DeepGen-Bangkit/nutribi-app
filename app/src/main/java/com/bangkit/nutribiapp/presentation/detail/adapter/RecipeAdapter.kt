package com.bangkit.nutribiapp.presentation.detail.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.FoodRecipe
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.presentation.recipe.DetailRecipeActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.items_detail_resep.view.img_resep
import kotlinx.android.synthetic.main.items_detail_resep.view.tv_title
import java.util.ArrayList
import kotlinx.android.synthetic.main.items_detail_resep.view.*
import java.util.*

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.ListViewHolder>() {

    private var listData = ArrayList<SearchRecipeItemResponse>()

    fun setData(newListData: List<SearchRecipeItemResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_detail_resep, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: SearchRecipeItemResponse) {
            with(itemView) {
                tv_title.text = data.name
                Glide.with(context).load(data.image).into(img_resep)
                tv_kcal.text = data.kcal_total.toString() + " kcal"
                tv_fat.text = "Lemak " + data.lemak_total.toString() + " g"
                tv_karbo.text = "Karbohidrat " + data.karbo_total.toString() + " g"
                tv_protein.text = "Protein " + data.protein_total.toString() + " g"


//                Log.d("TAG", "bind: " + data.image)
//
//                if ("/https%3A/" == data.image?.take(10)) {
//                    Glide.with(context).load("https://" + data.image.takeLast(data.image.length - 10)).into(img_resep)
//                } else {
//                    Glide.with(context).load(data.image).into(img_resep)
//                }

                setOnClickListener {
                    DetailRecipeActivity.start(context, data)
                }
            }
        }
    }
}