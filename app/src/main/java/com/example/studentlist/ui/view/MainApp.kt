package com.example.studentlist.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentlist.data.model.listOfStudents
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.ui.view.components.AppBarComponent
import com.example.studentlist.ui.view.components.StudentItem

@Preview(showBackground = true)
@Composable
fun MainApp() {
    Scaffold(
        topBar = {
            AppBarComponent()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(Dimensions.dimens16)
        ) {
            itemsIndexed(listOfStudents) { index, student ->
                StudentItem(
                    studentName = student.name,
                    studentAge = student.age,
                    studentDepartment = student.department,
                    studentRegNumber = student.avatar
                )
                if (index < listOfStudents.size - 1) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}