package com.example.studentlist.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.studentlist.R
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.ui.theme.FontSize

@Composable
fun StudentItem(
    modifier: Modifier = Modifier,
    studentName: String,
    studentAge: Int,
    studentDepartment: String,
    studentRegNumber: String,
    flipped: Boolean = false
) {
    val image: @Composable () -> Unit = {
        Image(
            modifier = Modifier
                .size(Dimensions.dimens50)
                .clip(
                    shape = RoundedCornerShape(size = Dimensions.dimens5)
                )
                .padding(end = Dimensions.dimens8),
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Profile picture"
        )
    }

    val studentOthers = listOf("$studentAge years", studentDepartment, studentRegNumber)

    val column: @Composable () -> Unit = {
        ColumnItem(
            studentName = studentName,
            studentOthers = studentOthers.let { if (flipped) it.reversed() else it }
                .joinToString(" | "),
            horizontalAlignment = if (flipped) Alignment.End else Alignment.Start
        )
    }

    val itemFlow = listOf(image, column).let {
        if (flipped) it.reversed() else it
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        if (flipped) Spacer(modifier = Modifier.weight(1f))
        itemFlow.forEach {
            it()
        }
    }
}

@Composable
fun ColumnItem(
    studentName: String,
    studentOthers: String,
    horizontalAlignment: Alignment.Horizontal
) {
    Column(
        horizontalAlignment = horizontalAlignment
    ) {
        CustomTextView(
            text = studentName,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textSize = FontSize.fontSize14
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomTextView(
                text = studentOthers
            )
        }
    }
}