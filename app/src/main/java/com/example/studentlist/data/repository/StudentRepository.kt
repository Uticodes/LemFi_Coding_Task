package com.example.studentlist.data.repository

import com.example.studentlist.data.remote.dto.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    suspend fun getAllStudents(): Flow<Result<List<Student>>>
}