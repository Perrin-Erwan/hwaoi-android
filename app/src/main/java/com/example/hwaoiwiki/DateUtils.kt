package com.example.hwaoiwiki

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    private const val DISPLAY_FORMAT = "dd/MM/yyyy"
    private const val FULL_DISPLAY_FORMAT = "dd/MM/yyyy HH:mm"

    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat(DISPLAY_FORMAT, Locale.getDefault())
        return sdf.format(Date())
    }

    fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat(FULL_DISPLAY_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
