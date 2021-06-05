package com.bangkit.nutribiapp.presentation.recipe

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.presentation.recipe.ingredient.IngredientRecipeFragment
import com.bangkit.nutribiapp.presentation.recipe.instruction.InstructionRecipeFragment

class SectionsPagerAdapter(activity: AppCompatActivity, private val searchRecipeItemResponse: SearchRecipeItemResponse) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = IngredientRecipeFragment(searchRecipeItemResponse)
            1 -> fragment = InstructionRecipeFragment(searchRecipeItemResponse)
        }

        return fragment as Fragment
    }
}