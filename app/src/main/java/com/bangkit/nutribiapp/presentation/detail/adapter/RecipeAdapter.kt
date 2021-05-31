package com.bangkit.nutribiapp.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.RecipeResponse
import com.bangkit.nutribiapp.presentation.recipe.DetailRecipeActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.items_detail_resep.view.img_resep
import kotlinx.android.synthetic.main.items_detail_resep.view.tv_content
import kotlinx.android.synthetic.main.items_detail_resep.view.tv_title
import java.util.ArrayList

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.ListViewHolder>() {

    private var listData = ArrayList<RecipeResponse>()

    fun setData(newListData: List<RecipeResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_detail_resep, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: RecipeResponse) {
            with(itemView) {
                Glide.with(this).load(data.img).into(img_resep)
                tv_title.text = data.name
                tv_content.text = data.gram
                setOnClickListener{
                    DetailRecipeActivity.start(context)
                }
            }
        }
    }
}