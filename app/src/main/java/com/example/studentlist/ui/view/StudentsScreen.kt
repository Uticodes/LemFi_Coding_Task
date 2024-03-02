package com.example.studentlist.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.studentlist.data.remote.dto.Student
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.ui.view.components.StudentItem

@Composable
fun StudentsScreen(
    studentList: List<Student>?,
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
                    flipped = (index % 2 != 0)
                )
                if (index < students.size) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }

    }
}