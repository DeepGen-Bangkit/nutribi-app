package com.bangkit.nutribiapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RegisterRequest(
    var name: String? = null,
    var email: String? = null,
    var password1: String? = null,
    var password2: String? = null,
    var date_birth: String? = null,
    var phase: Int? = null,
    var ttl: String? = null,
    var hpht: String? = null,
    var hpl: String? = null
) : Parcelable