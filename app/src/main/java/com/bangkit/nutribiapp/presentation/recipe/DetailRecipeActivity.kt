package com.bangkit.nutribiapp.presentation.recipe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.databinding.ActivityDetailRecipeBinding
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.model.Step
import com.bangkit.nutribiapp.utils.Const
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRecipeBinding

    lateinit var searchRecipeItemResponse: SearchRecipeItemResponse

    companion object {

        fun start(context: Context, searchRecipeItemResponse: SearchRecipeItemResponse) {
            val intent = Intent(context, DetailRecipeActivity::class.java)
            intent.putExtra(Const.EXTRA_DETAIL_RECIPE, searchRecipeItemResponse)
            context.startActivity(intent)
        }

        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchRecipeItemResponse =
            intent.getParcelableExtra(Const.EXTRA_DETAIL_RECIPE) ?: SearchRecipeItemResponse()

//        setDataDummy()
        setupUI()

        val sectionsPagerAdapter = SectionsPagerAdapter(this, searchRecipeItemResponse)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    private fun setupUI() {

        with(binding) {
            Glide.with(this@DetailRecipeActivity)
                .load(searchRecipeItemResponse.image)
                .into(imgRecipe)

            tvName.text = searchRecipeItemResponse.name
            tvTime.text = searchRecipeItemResponse.estimated + " menit"
            tvFat.text = searchRecipeItemResponse.lemak_total.toString() + " g"
            tvKarbo.text = searchRecipeItemResponse.karbo_total.toString() + " g"
            tvProtein.text = searchRecipeItemResponse.protein_total.toString() + " g"

            progressLemak.progress = searchRecipeItemResponse.lemak_presentase?.toInt() ?: 0
            progressKarbo.progress = searchRecipeItemResponse.karbo_presentase?.toInt() ?: 0
            progressProtein.progress = searchRecipeItemResponse.protein_presentase?.toInt() ?: 0
        }
    }

    private fun setDataDummy() {
        Glide.with(this)
            .load("https://www.holidify.com/images/cmsuploads/compressed/jakarta-food-09076010_20190618155553.jpg")
            .into(binding.imgRecipe)

        binding.tvName.text = "Sop Ayam"
        binding.tvTime.text = "60 menit"

        val listStep = mutableListOf<Step>()

        for(i in 0..11){
            listStep.add(
                Step(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor consectetur dictum. Donec laoreet consectetur laoreet. Cras sodales augue non risus hendrerit egestas nec id sapien. Donec bibendum placerat massa non sagittis. Etiam nulla sem, fringilla a dictum vel, lobortis efficitur ligula. Nunc accumsan ac lectus at luctus. Integer suscipit lorem elit, in convallis tortor ullamcorper in. Quisque nec tellus nisl. Aliquam sed nisi eget ante porttitor placerat aliquam nec ante. Aenean congue eros sed purus sagittis, eu ultrices lorem tristique. Donec imperdiet imperdiet leo viverra maximus. Vivamus malesuada nunc ex, nec dapibus lorem eleifend quis. Maecenas tincidunt vestibulum leo quis efficitur. Nam volutpat tellus sed sapien tincidunt, sed pulvinar quam consectetur. Morbi efficitur neque purus, eu ullamcorper felis pretium at."
                )
            )
        }

        searchRecipeItemResponse = SearchRecipeItemResponse(
            step = listStep
        )
    }
}