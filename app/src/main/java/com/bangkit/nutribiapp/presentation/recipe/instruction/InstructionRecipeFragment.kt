package com.bangkit.nutribiapp.presentation.recipe.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.SearchRecipeItemResponse
import com.bangkit.nutribiapp.presentation.recipe.instruction.adapter.InstructionAdapter
import kotlinx.android.synthetic.main.fragment_instruction_recipe.rv_instructions

class InstructionRecipeFragment(val searchRecipeItemResponse: SearchRecipeItemResponse) : Fragment() {

    private val instructionAdapter: InstructionAdapter by lazy {
        InstructionAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instruction_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        instructionAdapter.setData(searchRecipeItemResponse.step)
    }

    private fun initRecyclerView() {
        rv_instructions.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = instructionAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
    }
}