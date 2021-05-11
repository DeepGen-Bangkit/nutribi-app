package com.bangkit.nutribiapp.presentation.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit.nutribiapp.R
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseAwalMenyusui
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseKehamilan
import kotlinx.android.synthetic.main.activity_fase_menu.btnFaseMpasi

class FaseMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fase_menu)

        initAction()
    }

    private fun initAction() {
        btnFaseKehamilan.setOnClickListener{
            Toast.makeText(this, "Fase Kehamilan", Toast.LENGTH_SHORT).show()
        }
        btnFaseAwalMenyusui.setOnClickListener {
            Toast.makeText(this, "Fase Awal Menyusui", Toast.LENGTH_SHORT).show()
        }
        btnFaseMpasi.setOnClickListener {
            Toast.makeText(this, "Fase MPASI", Toast.LENGTH_SHORT).show()
        }
    }
}