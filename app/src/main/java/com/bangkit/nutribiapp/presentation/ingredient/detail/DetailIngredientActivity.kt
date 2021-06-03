package com.bangkit.nutribiapp.presentation.ingredient.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.databinding.ActivityDetailIngredientBinding
import com.bangkit.nutribiapp.model.Food

class DetailIngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailIngredientBinding

    companion object {
        const val EXTRA_INGREDIENT = "extra_ingredient"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ingredient = intent.getParcelableExtra<Food>(EXTRA_INGREDIENT)

        if (ingredient != null) {
            setupUI(ingredient)
        }


    }

    private fun setupUI(ingredient: Food) {

        with(binding) {
            tvName.text = ingredient.name
            tvGram.text = ingredient.count.toString()
            tvCal.text = ingredient.kcal.toString()

            //Nutrition
            val nutrition = ingredient.nutrition

            tvScoreKarbo.text = nutrition?.carbo
            tvScoreProteion.text = nutrition?.protein
            tvScoreFat.text = nutrition?.lemak

            tvAir.text = nutrition?.air
            tvSerat.text = nutrition?.serat
            tvAbu.text = nutrition?.abu
            tvKalsium.text = nutrition?.kalsium
            tvFosfor.text = nutrition?.fosfor
            tvZatBesi.text = nutrition?.besi
            tvNatrium.text = nutrition?.natrium
            tvKalium.text = nutrition?.kalium
            tvTembaga.text = nutrition?.tembaga
            tvSeng.text = nutrition?.seng
            tvRetinol.text = nutrition?.retinol
            tvBetakaroten.text = nutrition?.b_kar
            tvKaroten.text = nutrition?.kar_total
            tvThiamin.text = nutrition?.thiamin
            tvRiboflavin.text = nutrition?.riboflavin
            tvNiasin.text = nutrition?.niasin
            tvVitaminC.text = nutrition?.vit_c
        }
    }
}

