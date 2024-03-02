package com.example.studentlist.data.remote

import com.example.studentlist.data.remote.dto.Student
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/students")
    suspend fun getStudents(): Response<List<Student>>
}