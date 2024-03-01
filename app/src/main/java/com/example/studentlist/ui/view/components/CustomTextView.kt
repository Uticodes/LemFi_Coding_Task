package com.example.studentlist.ui.view.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.studentlist.ui.theme.FontSize

@Composable
fun CustomTextView(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = FontSize.fontSize12,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Gray,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign= textAlign,
        style = TextStyle(
            fontWeight = fontWeight,
            fontSize = textSize,
            color = color,
        ),
    )
}