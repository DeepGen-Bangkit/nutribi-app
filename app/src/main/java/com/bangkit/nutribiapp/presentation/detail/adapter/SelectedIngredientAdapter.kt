package com.bangkit.nutribiapp.presentation.detail.adapter

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse
import kotlinx.android.synthetic.main.items_bahan.view.edtGramCount
import kotlinx.android.synthetic.main.items_bahan.view.tv_name
import java.util.ArrayList

class SelectedIngredientAdapter : RecyclerView.Adapter<SelectedIngredientAdapter.ListViewHolder>() {

    var listData = ArrayList<SearchIngredientItemResponse>()

    fun setData(newListData: List<SearchIngredientItemResponse>?) {
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

        fun bind(data: SearchIngredientItemResponse) {
            with(itemView) {
                tv_name.text = data.name
//                tv_content.text = data.kcalPerGram
//                btn_add.setOnClickListener{
//                }

//                edtGramCount.addTextChangedListener(TextWatcher{
//
//                })

                edtGramCount.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable) {
                    }

                    override fun beforeTextChanged(
                        s: CharSequence, start: Int,
                        count: Int, after: Int
                    ) {
                    }

                    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                        if (s.toString() == "") {
                            data.gram = 0
                        } else {
                            data.gram = s.toString().toInt()
                        }

                        Log.d("TAG", "onTextChanged: " + data.gram)
                    }
                })

            }
        }
    }
}