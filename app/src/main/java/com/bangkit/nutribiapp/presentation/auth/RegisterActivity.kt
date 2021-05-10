package com.bangkit.nutribiapp.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.presentation.auth.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.activity_register.btnLogin
import kotlinx.android.synthetic.main.activity_register.btnRegister

class RegisterActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initAction()
    }

    private fun initAction() {
        btnRegister.setOnClickListener {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}