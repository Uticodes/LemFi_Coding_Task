package com.example.studentlist.data.repository

import com.example.studentlist.data.local.StudentData
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    suspend fun getAllStudents(): Flow<Result<List<StudentData>>>
}