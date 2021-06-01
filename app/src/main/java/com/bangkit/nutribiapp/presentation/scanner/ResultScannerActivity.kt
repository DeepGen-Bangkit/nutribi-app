package com.bangkit.nutribiapp.presentation.scanner

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.detail.SelectedFoodActivity
import com.bangkit.nutribiapp.presentation.ingredient.IngredientViewModel
import com.bangkit.nutribiapp.presentation.nutrition.adapter.DetailNutritionAdapter
import com.bangkit.nutribiapp.utils.Const
import com.bangkit.nutribiapp.utils.DataObject.img
import com.bangkit.nutribiapp.utils.DataObject.searchRecipeResponse
import kotlinx.android.synthetic.main.activity_result_scanner.btnNextSelectedIngredientDetection
import kotlinx.android.synthetic.main.activity_result_scanner.img_scanner
import kotlinx.android.synthetic.main.activity_result_scanner.rv_ingredients
import kotlinx.android.synthetic.main.activity_selected_food.rv_bahan
import kotlinx.android.synthetic.main.activity_selected_food.rv_resep
import org.koin.android.viewmodel.ext.android.viewModel
import org.tensorflow.lite.task.vision.detector.Detection

class ResultScannerActivity : AppCompatActivity() {

    private val ingredientViewModel: IngredientViewModel by viewModel()

    private val detailNutritionAdapter: DetailNutritionAdapter by lazy {
        DetailNutritionAdapter()
    }

    companion object {

        fun start(context: Context, ingredients : String) {
            val intent = Intent(context, ResultScannerActivity::class.java)
            intent.putExtra(Const.EXTRA_LIST_DETECTION, ingredients)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_scanner)

        val ingredients = intent.getStringExtra(Const.EXTRA_LIST_DETECTION)
        Log.d("TAG", "onCreate: " + ingredients)

        initRecyclerView()
        initObserver()
        initUI(img)
        initAction()
    }

    private fun initAction() {
        btnNextSelectedIngredientDetection.setOnClickListener{
            searchRecipeResponse = detailNutritionAdapter.listData.toMutableSet()
            SelectedFoodActivity.start(this)
        }
    }

    private fun initUI(img: Bitmap) {
        img_scanner.setImageBitmap(img)
    }

    private fun initObserver() {
        ingredientViewModel.getSearchIngredient("")
        ingredientViewModel.searchIngredientItemResponse.observe(this){
            detailNutritionAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        rv_ingredients.apply {
            layoutManager = LinearLayoutManager(this@ResultScannerActivity)
            adapter = detailNutritionAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }

    }
}