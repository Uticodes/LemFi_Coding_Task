package com.example.studentlist.data.repository

import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.ApiService
import com.example.studentlist.utils.mockStudentDataList
import com.example.studentlist.utils.mockStudentResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class StudentRepositoryImplTest {

    @MockK
    lateinit var mockApiService: ApiService

    @MockK
    lateinit var mockStudentDao: StudentDao

    private lateinit var repository: StudentRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        repository = StudentRepositoryImpl(mockStudentDao, mockApiService)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getAllStudents and updates database with API data on success`() = runTest {

        coEvery { mockStudentDao.getAllStudents() } returns flowOf(mockStudentResponse)
        coEvery { mockApiService.getStudents() } returns Response.success(mockStudentResponse)

        val result = repository.getAllStudents().first()

        assertTrue(result.isSuccess)
        result.onSuccess { students ->
            mockStudentDao.insertAll(mockStudentResponse)
            assertEquals(mockStudentDataList, students)
        }

        val initialDbResult = mockStudentDao.getAllStudents()
        assertTrue(initialDbResult.toString().isNotEmpty())
        assertEquals(mockStudentDataList.first().name, initialDbResult.first().first().name)

        advanceUntilIdle()

        coVerify { mockStudentDao.getAllStudents() }
    }

    @Test
    fun `getAllStudents emits failure when API call fails`() = runTest {

        val errorMessage = "Error message"
        coEvery { mockStudentDao.getAllStudents() } returns flowOf(mockStudentResponse)
        coEvery { mockApiService.getStudents() } returns Response.error(
            500,
            errorMessage.toResponseBody()
        )

        val result = repository.getAllStudents().first()

        result.onFailure {
            assertEquals(errorMessage, it.message)
        }

        coVerify { mockStudentDao.getAllStudents() }
    }

}