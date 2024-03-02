package com.example.studentlist.ui.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentlist.data.repository.StudentRepository
import com.example.studentlist.dispatcher.DispatcherHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentsViewModel @Inject constructor(
    private val repository: StudentRepository,
    private val dispatcher: DispatcherHelper
): ViewModel() {
    private val _uiState = MutableStateFlow(StudentUIState())
    val uiState: StateFlow<StudentUIState> = _uiState

    init {
        getAllStudents()
    }

    fun getAllStudents() {
        viewModelScope.launch(dispatcher.io()) {
            _uiState.update { state -> state.copy(isLoading = true) }
            repository.getAllStudents().collect { result ->
                result.onSuccess { students ->
                    _uiState.update { state -> state.copy(isLoading = false, students = students) }
                }.onFailure { error ->
                    _uiState.update { state -> state.copy(isLoading = false, errorMessage = error.message) }
                }
            }
        }
    }

}