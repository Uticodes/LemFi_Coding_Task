package com.example.studentlist.ui.view.viewModel

import com.example.studentlist.data.remote.dto.Student

data class StudentUIState(
    val isLoading: Boolean = false,
    val students: List<Student>? = emptyList(),
    val errorMessage: String? = null
)