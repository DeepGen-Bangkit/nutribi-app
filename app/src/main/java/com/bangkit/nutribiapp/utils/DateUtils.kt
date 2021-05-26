package com.bangkit.nutribiapp.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateUtils {

    private val calendar by lazy {
        Calendar.getInstance()
    }

    fun showCalenderPicker(context: Context, textView: TextView, linearLayout: LinearLayout) {
        val dateListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(dateFormat, Locale.US)
//            this.setTextColor(resources.getColor(R.color.black))
            textView.text = sdf.format(calendar.time)
        }

        linearLayout.setOnClickListener {
            DatePickerDialog(
                context,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}

fun String.formatDate(): String {
    val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}