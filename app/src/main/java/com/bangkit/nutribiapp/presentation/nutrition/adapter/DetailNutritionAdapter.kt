package com.bangkit.nutribiapp.presentation.nutrition.adapter

import android.graphics.drawable.PictureDrawable
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
                tv_fat.text = "Lemak " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"
                tv_karbo.text = "Karbohidrat " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"
                tv_protein.text = "Protein " + (data.nutrition?.get(0)?.lemak ?: "-") + "/ 100g"
//                Glide.with(context).load(data.image).into(img_ingredient)

                GlideApp.with(this)
                    .load(data.image)
                    .into(img_ingredient)

//                val requestBuilder: GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> = Glide.with(mContext)
//                    .using(Glide.buildStreamModelLoader(Uri::class.java, mContext), InputStream::class.java)
//                    .from(Uri::class.java)
//                    .`as`(SVG::class.java)
//                    .transcode(SvgDrawableTranscoder(), PictureDrawable::class.java)
//                    .sourceEncoder(StreamEncoder())
//                    .cacheDecoder(FileToStreamDecoder(SVGDecoder()))
//                    .decoder(SVGDecoder())
//                    .listener(SvgSoftwareLayerSetter<Uri>())
//
//                requestBuilder
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
//                    .load(Uri.parse("URL"))
//                    .into(cardHolder.iv_card)

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
