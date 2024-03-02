package com.example.studentlist.data.repository

import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.ApiService
import com.example.studentlist.data.remote.dto.Student
import com.example.studentlist.utils.performApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val apiService: ApiService
) : StudentRepository {
    override suspend fun getAllStudents(): Flow<Result<List<Student>>> = flow {
        emitAll(studentDao.getAllStudents().map { Result.success(it) })

        val studentsFromApi = performApiCall(apiCall = { apiService.getStudents() })
        studentsFromApi.onSuccess { students ->
            students?.let { studentDao.insertAll(it) }.also {
                emitAll(studentDao.getAllStudents().map { Result.success(it) })
            }
        }.onFailure {
            emit(Result.failure(it))
        }
    }
}