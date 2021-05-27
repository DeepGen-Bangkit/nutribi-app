package com.bangkit.nutribiapp.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.IngredientResponse
import kotlinx.android.synthetic.main.items_bahan.view.tv_content
import kotlinx.android.synthetic.main.items_bahan.view.tv_name
import java.util.ArrayList

class SelectedIngredientAdapter : RecyclerView.Adapter<SelectedIngredientAdapter.ListViewHolder>() {

    private var listData = ArrayList<IngredientResponse>()

    fun setData(newListData: List<IngredientResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_bahan, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: IngredientResponse) {
            with(itemView) {
                tv_name.text = data.name
                tv_content.text = data.kcalPerGram
//                btn_add.setOnClickListener{
//                }
            }
        }
    }
}