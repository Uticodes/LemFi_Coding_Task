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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.example.studentlist.R
import com.example.studentlist.data.remote.dto.Student
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.ui.theme.FontSize
import timber.log.Timber

@Composable
fun StudentItem(
    modifier: Modifier = Modifier,
    student: Student,
    flipped: Boolean = false
) {
    Timber.d("IMAGE: ${student.avatar}")
    val image: @Composable () -> Unit = {
        Image(
            modifier = Modifier
                .size(Dimensions.dimens50)
                .clip(
                    RoundedCornerShape(size = Dimensions.dimens10)
                ),
            painter = rememberAsyncImagePainter(
                model = "https://play-lh.googleusercontent.com/TpuBDn1750YoVkiVqKVaq06Q_hk28yF7YKtN9spdLTV0KvPQk1Wasczo9mUTTklymMlp",
                ),
            contentDescription = stringResource(R.string.profile_picture)
        )
    }

    val studentOthers =
        listOf(stringResource(R.string.years, student.age), student.department, "NN/B19/281")

    val column: @Composable () -> Unit = {
        ColumnItem(
            modifier = Modifier.padding(Dimensions.dimens8),
            studentName = student.name.orEmpty(),
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