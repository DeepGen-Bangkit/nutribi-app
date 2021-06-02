package com.bangkit.nutribiapp.utils

import android.graphics.Bitmap
import android.graphics.Bitmap.Config.ARGB_8888
import com.bangkit.nutribiapp.model.LoginResponse
import com.bangkit.nutribiapp.model.RegisterRequest
import com.bangkit.nutribiapp.model.SearchIngredientItemResponse

object DataObject {

    var loginResponse = LoginResponse()
    var registerRequest = RegisterRequest()

    var searchRecipeResponse = mutableSetOf<SearchIngredientItemResponse>()
    var searchRecipeResponseWithGram = mutableSetOf<SearchIngredientItemResponse>()

    var w: Int = 1
    var h:Int = 1
    var conf = ARGB_8888
    var img: Bitmap = Bitmap.createBitmap(w,h,conf)
}