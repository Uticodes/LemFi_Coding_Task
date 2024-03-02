package com.example.studentlist.ui.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.studentlist.ui.theme.FontSize

@Composable
fun ColumnItem(
    modifier: Modifier,
    studentName: String,
    studentOthers: String,
    horizontalAlignment: Alignment.Horizontal
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
    ) {
        CustomTextView(
            text = studentName,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textSize = FontSize.fontSize14
        )
        CustomTextView(
            text = studentOthers
        )
    }
}