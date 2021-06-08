package com.bangkit.nutribiapp.presentation.nutrition.adapter

import android.graphics.drawable.PictureDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse
import com.bangkit.nutribiapp.utils.GlideApp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.items_detail_ingredient.view.img_ingredient
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_count
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_fat
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_karbo
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_name
import kotlinx.android.synthetic.main.items_detail_ingredient.view.tv_protein
import java.util.ArrayList

class DetailNutritionAdapter : RecyclerView.Adapter<DetailNutritionAdapter.ListViewHolder>() {

    var listData = ArrayList<SearchIngredientItemResponse>()

    fun setData(newListData: List<SearchIngredientItemResponse>?) {
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

        fun bind(data: SearchIngredientItemResponse) {
            with(itemView) {
                tv_name.text = data.name
                tv_count.visibility = View.GONE
                tv_fat.text = "Lemak " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"
                tv_karbo.text = "Karbohidrat " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"
                tv_protein.text = "Protein " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"

                if("/https%3A/" == data.image?.take(10)){
                    Log.d("TAG", "bind: true")
                    GlideApp.with(  this).load("https://"+data.image.takeLast(data.image.length - 10)).into(img_ingredient)
//                    GlideApp.with(this).load("https://storage.googleapis.com/svg-image/seafood.svg").into(img_ingredient)
                } else {
                    Log.d("TAG", "bind: false")
                    GlideApp.with(this).load(data.image).into(img_ingredient)
                }

//                GlideApp.with(this)
//                    .load(data.image)
//                    .into(img_ingredient)

            }
        }
    }
}
