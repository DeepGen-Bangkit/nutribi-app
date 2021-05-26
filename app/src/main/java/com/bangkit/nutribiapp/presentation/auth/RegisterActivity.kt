package com.bangkit.nutribiapp.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.utils.DataObject
import com.bangkit.nutribiapp.utils.DateUtils
import com.bangkit.nutribiapp.utils.formatDate
import kotlinx.android.synthetic.main.activity_register.btnLogin
import kotlinx.android.synthetic.main.activity_register.btnRegister
import kotlinx.android.synthetic.main.activity_register.containerMomBirthDate
import kotlinx.android.synthetic.main.activity_register.edtConfirmPassword
import kotlinx.android.synthetic.main.activity_register.edtEmail
import kotlinx.android.synthetic.main.activity_register.edtName
import kotlinx.android.synthetic.main.activity_register.edtPassword
import kotlinx.android.synthetic.main.activity_register.tvMomBirthDate

class RegisterActivity : AppCompatActivity() {

    private val dateUtils: DateUtils by lazy {
        DateUtils()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initAction()

        setDataDummy()
    }

    private fun setDataDummy() {
        edtEmail.setText("c@c.com")
        edtPassword.setText("12345678Aa")
        edtConfirmPassword.setText("12345678Aa")
        edtName.setText("Putri")
        tvMomBirthDate.setText("12/12/2000")
    }

    private fun initAction() {
        btnRegister.setOnClickListener {
            with(DataObject.registerRequest) {
                email = edtEmail.text.toString()
                password1 = edtPassword.text.toString()
                password2 = edtConfirmPassword.text.toString()
                name = edtName.text.toString()
                date_birth = tvMomBirthDate.text.toString().formatDate()
            }

            FaseMenuActivity.start(this)
            startActivity(Intent(this, FaseMenuActivity::class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        dateUtils.showCalenderPicker(this, tvMomBirthDate, containerMomBirthDate)
    }
}