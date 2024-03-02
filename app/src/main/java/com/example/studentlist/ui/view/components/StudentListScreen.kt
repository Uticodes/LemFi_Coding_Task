package com.example.studentlist.ui.view.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.studentlist.data.local.StudentData
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.utils.HandleItemFlip.shouldFlip

@Composable
fun StudentListScreen(
    studentList: List<StudentData>?,
    modifier: Modifier = Modifier
    ) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(Dimensions.dimens16)
    ) {

        studentList?.let { students ->
            itemsIndexed(students) { index, student ->
                StudentItem(
                    student = student,
                    flipped = shouldFlip(index)
                )
                if (index < students.size) {
                    Divider(
                        modifier.padding(vertical = Dimensions.dimens5),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }

    }
}