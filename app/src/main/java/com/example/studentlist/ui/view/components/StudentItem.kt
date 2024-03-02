package com.example.studentlist.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import com.example.studentlist.R
import com.example.studentlist.data.local.StudentData
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.utils.Constants.TEST_IMAGE_URL
import timber.log.Timber

@Composable
fun StudentItem(
    modifier: Modifier = Modifier,
    student: StudentData,
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
                model = TEST_IMAGE_URL
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