package com.bangkit.nutribiapp.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.auth.viewmodel.AuthViewModel
import com.bangkit.nutribiapp.presentation.main.MainActivity
import com.bangkit.nutribiapp.utils.DataObject.registerRequest
import com.bangkit.nutribiapp.utils.DateUtils
import com.bangkit.nutribiapp.utils.formatDate
import kotlinx.android.synthetic.main.activity_fase_form.btnNextFormFase
import kotlinx.android.synthetic.main.activity_fase_form.btnObjectDetection
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
import com.bangkit.nutribiapp.presentation.objectdetection.ObjectDetection
import com.bangkit.nutribiapp.presentation.scanner.ResultScannerActivity

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

        // Just For Testing Purpose
        setDataDummy()
    }

    private fun setDataDummy() {
        tvHpht.text = "12/12/2000"
        tvHpl.text = "12/12/2000"
    }

    private fun initObserver() {
        authViewModel.registerResponse.observe(this){
            if(it.msg != null){
                Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                MainActivity.start(this)
            }
        }
    }

    private fun initAction() {
//        dateUtils.showCalenderPicker(this, tvMomBirthDate, containerMomBirthDate)
        dateUtils.showCalenderPicker(this, tvHpht, containerHpht)
        dateUtils.showCalenderPicker(this, tvHpl, containerHpl)
        dateUtils.showCalenderPicker(this, tvBabyBirthDate, containerBabyBirthDate)

        btnNextFormFase.setOnClickListener {
            with(registerRequest){
                hpht = tvHpht.text.toString().formatDate()
                hpl = tvHpl.text.toString().formatDate()
            }
            authViewModel.postRegister(registerRequest)
        }
        btnObjectDetection.setOnClickListener {
//            val intent = Intent(this, ObjectDetection::class.java)
//            startActivity(intent)
            ObjectDetection.start(this)
        }
    }
}