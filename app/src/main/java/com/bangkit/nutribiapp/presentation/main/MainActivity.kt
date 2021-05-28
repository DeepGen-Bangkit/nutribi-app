package com.bangkit.nutribiapp.presentation.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.bangkit.nutribiapp.R.id
import com.bangkit.nutribiapp.R.layout
import com.bangkit.nutribiapp.presentation.auth.FaseFormActivity
import kotlinx.android.synthetic.main.activity_main.navView

class MainActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

//        val appBarConfiguration = AppBarConfiguration.Builder(
//            id.navMovie,
//            id.navTv,
//            id.navFavorite
//        ).build()

        val navController = Navigation.findNavController(
            this,
            id.navHostFragment
        )

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }
}