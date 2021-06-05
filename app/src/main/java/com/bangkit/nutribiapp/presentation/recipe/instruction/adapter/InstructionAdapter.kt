package com.bangkit.nutribiapp.presentation.recipe.instruction.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.Step
import kotlinx.android.synthetic.main.items_recipe_instruction.view.tv_insctruction
import kotlinx.android.synthetic.main.items_recipe_instruction.view.tv_step
import java.util.ArrayList

class InstructionAdapter : RecyclerView.Adapter<InstructionAdapter.ListViewHolder>() {

    private var listData = ArrayList<Step>()

    fun setData(newListData: List<Step>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_recipe_instruction, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data, position)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: Step, position: Int) {
            with(itemView) {
                tv_step.text = "Langkah " + (position + 1).toString()
                tv_insctruction.text = data.step
//                tv_name.text = data.name
//                tv_content.text = data.kcal.toString() + "kcal/100g"
//                btn_add.setOnClickListener{
//                    DataObject.searchRecipeResponse.add(data)
//                    Toast.makeText(context, "Bahan Behasil Ditambahkan", Toast.LENGTH_SHORT).show()
//                    Log.d("TAG", "bind: " + DataObject.searchRecipeResponse)
//                }
            }
        }
    }
}