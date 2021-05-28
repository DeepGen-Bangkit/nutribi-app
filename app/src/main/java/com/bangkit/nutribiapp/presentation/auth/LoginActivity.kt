package com.bangkit.nutribiapp.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.model.LoginRequest
import com.bangkit.nutribiapp.presentation.auth.viewmodel.AuthViewModel
import com.bangkit.nutribiapp.presentation.main.MainActivity
import com.bangkit.nutribiapp.utils.DataObject
import kotlinx.android.synthetic.main.activity_login.btnLogin
import kotlinx.android.synthetic.main.activity_login.btnRegister
import kotlinx.android.synthetic.main.activity_login.edtEmail
import kotlinx.android.synthetic.main.activity_login.edtPassword
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initObserver()
        initAction()

        setDataDummy()
    }

    private fun setDataDummy() {
        edtEmail.setText("a@a.com")
        edtPassword.setText("12345678Aa")
    }

    private fun initObserver() {
        authViewModel.loginResponse.observe(this){
            if (it.token != null){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                DataObject.loginResponse = it
                MainActivity.start(this)
            }
        }
    }

    private fun initAction() {
        btnLogin.setOnClickListener {
            authViewModel.postLogin(LoginRequest(edtEmail.text.toString(), edtPassword.text.toString()))
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}