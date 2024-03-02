package com.example.studentlist.utils

fun convertProfileId(hexProfileId: String): String {
    /*
    * Converting hexProfileId from "0x1" to a format like "NN/B19/281"
    * This function simply extracts the numeric part and appends it to a template string
    * You'll need to adjust the logic according to the actual conversion rules
    */

    // Convert hex to decimal
    val numericPart = hexProfileId.removePrefix("0x").toIntOrNull(16)
    return if (numericPart != null) {
        "NN/B19/$numericPart"
    } else {
        hexProfileId // Fallback to original ID if conversion is not possible
    }
}