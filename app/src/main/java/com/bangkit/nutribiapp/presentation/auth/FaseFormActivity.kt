package com.bangkit.nutribiapp.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.auth.viewmodel.AuthViewModel
import com.bangkit.nutribiapp.utils.DataObject.registerRequest
import com.bangkit.nutribiapp.utils.DateUtils
import kotlinx.android.synthetic.main.activity_fase_form.btnNextFormFase
import kotlinx.android.synthetic.main.activity_fase_form.containerFormBayi
import kotlinx.android.synthetic.main.activity_fase_form.containerFormKehamilan
import kotlinx.android.synthetic.main.activity_fase_form.tvLabelFase
import kotlinx.android.synthetic.main.layout_form_bayi.containerBabyBirthDate
import kotlinx.android.synthetic.main.layout_form_bayi.tvBabyBirthDate
import kotlinx.android.synthetic.main.layout_form_kehamilan.containerHpht
import kotlinx.android.synthetic.main.layout_form_kehamilan.containerHpl
import kotlinx.android.synthetic.main.layout_form_kehamilan.tvHpht
import kotlinx.android.synthetic.main.layout_form_kehamilan.tvHpl
import org.koin.android.viewmodel.ext.android.viewModel

class FaseFormActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModel()

    private val dateUtils: DateUtils by lazy {
        DateUtils()
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, FaseFormActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fase_form)

        initObserver()

        if (registerRequest.phase == 0) {
            containerFormKehamilan.visibility = View.VISIBLE
        } else if (registerRequest.phase == 1) {
            containerFormKehamilan.visibility = View.VISIBLE
        } else if (registerRequest.phase == 2) {
            tvLabelFase.text = "Form Bayi"
            containerFormBayi.visibility = View.VISIBLE
        }

        initAction()
    }

    private fun initObserver() {
        authViewModel.registerResponse.observe(this){
            if(it.msg != null){
                Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initAction() {
//        dateUtils.showCalenderPicker(this, tvMomBirthDate, containerMomBirthDate)
        dateUtils.showCalenderPicker(this, tvHpht, containerHpht)
        dateUtils.showCalenderPicker(this, tvHpl, containerHpl)
        dateUtils.showCalenderPicker(this, tvBabyBirthDate, containerBabyBirthDate)

        btnNextFormFase.setOnClickListener {
//            Log.d("TAG", "initAction: " + tvMomBirthDate.text.toString().formatDate())
            authViewModel.postRegister(registerRequest)
        }
    }
}