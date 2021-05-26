package com.bangkit.nutribiapp.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.nutribiapp.R
import com.bangkit.nutribiapp.utils.DataObject.registerRequest
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseAwalMenyusui
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseKehamilan
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseMpasi

class FaseMenuActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, FaseFormActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fase_menu)

        initAction()
    }

    private fun initAction() {
        btnFaseKehamilan.setOnClickListener {
            Toast.makeText(this, "Fase Kehamilan", Toast.LENGTH_SHORT).show()
            registerRequest.phase = 0
            FaseFormActivity.start(this)
        }
        btnFaseAwalMenyusui.setOnClickListener {
            Toast.makeText(this, "Fase Awal Menyusui", Toast.LENGTH_SHORT).show()
            registerRequest.phase = 1
            FaseFormActivity.start(this)
        }
        btnFaseMpasi.setOnClickListener {
            Toast.makeText(this, "Fase MPASI", Toast.LENGTH_SHORT).show()
            registerRequest.phase = 2
            FaseFormActivity.start(this)
        }
    }
}