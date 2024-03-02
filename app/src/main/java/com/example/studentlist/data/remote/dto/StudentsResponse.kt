package com.example.studentlist.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StudentsResponse(
    val id: String = "0",
    val name: String? = null,
    val age: Int? = 0,
    val department: String? = null,
    val avatar: String? = null,
    val profileId: String? = null,
)