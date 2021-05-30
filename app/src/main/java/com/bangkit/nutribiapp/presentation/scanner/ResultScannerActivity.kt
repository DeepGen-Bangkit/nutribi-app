package com.bangkit.nutribiapp.presentation.scanner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.nutribiapp.R

class ResultScannerActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ResultScannerActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_scanner)
    }
}