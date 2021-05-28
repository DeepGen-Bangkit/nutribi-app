package com.bangkit.nutribiapp.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.ingredient.IngredientActivity
import kotlinx.android.synthetic.main.fragment_home.btn_add_breakfast
import kotlinx.android.synthetic.main.fragment_home.btn_add_dinner
import kotlinx.android.synthetic.main.fragment_home.btn_add_lunch

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAction()
    }

    private fun initAction() {
        btn_add_breakfast.setOnClickListener{
            IngredientActivity.start(requireContext())
        }

        btn_add_lunch.setOnClickListener{
            IngredientActivity.start(requireContext())
        }

        btn_add_dinner.setOnClickListener{
            IngredientActivity.start(requireContext())
        }
    }
}