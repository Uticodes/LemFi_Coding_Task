package com.example.studentlist.utils

fun convertDaysToYears(days: Int): Int {
    return (days / 365.25).toInt()
}

fun formatAge(days: Int): Int {
    return convertDaysToYears(days)
}
