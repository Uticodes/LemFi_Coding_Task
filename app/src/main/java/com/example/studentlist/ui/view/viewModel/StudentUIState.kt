package com.example.studentlist.ui.view.viewModel

import com.example.studentlist.data.local.StudentData

data class StudentUIState(
    val isLoading: Boolean = false,
    val students: List<StudentData>? = emptyList(),
    val errorMessage: String? = null
)