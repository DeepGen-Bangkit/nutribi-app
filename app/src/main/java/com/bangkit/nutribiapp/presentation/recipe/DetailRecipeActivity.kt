package com.bangkit.nutribiapp.presentation.recipe

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.databinding.ActivityDetailRecipeBinding
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRecipeBinding

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DetailRecipeActivity::class.java)
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

        setDataDummy()

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) {tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    private fun setDataDummy() {
        Glide.with(this)
            .load("https://www.holidify.com/images/cmsuploads/compressed/jakarta-food-09076010_20190618155553.jpg")
            .into(binding.imgRecipe)

        binding.tvName.text = "Sop Ayam"
        binding.tvTime.text = "60 menit"

    }
}