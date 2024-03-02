package com.example.studentlist.data.repository

import com.example.studentlist.data.local.StudentData
import com.example.studentlist.data.local.StudentData.Companion.fromStudents
import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.ApiService
import com.example.studentlist.utils.performApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val apiService: ApiService
) : StudentRepository {
    override suspend fun getAllStudents(): Flow<Result<List<StudentData>>> = flow {
        val initialStudents = studentDao.getAllStudents().firstOrNull() ?: emptyList()
        emit(Result.success(fromStudents(initialStudents)))

        val studentsFromApi = performApiCall(apiCall = { apiService.getStudents() })

        studentsFromApi.onSuccess { students ->
            val studentList = students ?: emptyList()
            studentDao.insertAll(studentList)
            emit(Result.success(fromStudents(studentList + initialStudents)))
        }.onFailure {
            emit(Result.failure(it))
        }
    }
}