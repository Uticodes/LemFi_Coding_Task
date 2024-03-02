package com.example.studentlist.ui.view.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.studentlist.data.repository.StudentRepository
import com.example.studentlist.dispatcher.DispatcherHelperImplTest
import com.example.studentlist.utils.mockStudentDataList
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class StudentsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: StudentsViewModel
    private val dispatcherHelper = DispatcherHelperImplTest()

    @MockK
    private lateinit var repository: StudentRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = StudentsViewModel(repository, dispatcherHelper)
    }

    @Test
    fun `getAllStudents and update UI state correctly on success`() = runTest {
        coEvery { repository.getAllStudents() } returns flowOf(Result.success(mockStudentDataList))

        viewModel.getAllStudents()
        val uiState = viewModel.uiState.value
        advanceUntilIdle()

        assertFalse(uiState.isLoading)
        assertEquals(mockStudentDataList, uiState.students)
        assertNull(viewModel.uiState.value.errorMessage)
    }

    @Test
    fun `getAllStudents and update error message on error`() = runTest {
        val expectedError = "There is an error"

        coEvery { repository.getAllStudents() } returns
                flowOf(Result.failure(RuntimeException(expectedError)))

        viewModel.getAllStudents()
        val uiState = viewModel.uiState.value
        advanceUntilIdle()

        assertFalse(uiState.isLoading)
        assertEquals(expectedError, uiState.errorMessage)
    }

}