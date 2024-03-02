package com.example.studentlist.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "students")
data class Student(
    @PrimaryKey val id: String,
    val name: String? = null,
    val avatar: String? = null,
    val age: Int = 0,
    val department: String? = null,
    val profileId: String? = null,
)