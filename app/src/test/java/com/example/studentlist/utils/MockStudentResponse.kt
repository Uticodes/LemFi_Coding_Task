package com.example.studentlist.utils

import com.example.studentlist.data.local.StudentData
import com.example.studentlist.data.remote.dto.Student

val mockStudentResponse = listOf(
    Student(
        id = "1",
        name = "Brian Barrows",
        avatar = Constants.TEST_IMAGE_URL,
        age = 66741,
        department = "Grocery",
        profileId = "0x0",
    ),
)

val mockStudentDataList = listOf(
    StudentData(
        id = "1",
        name = "Brian Barrows",
        avatar = Constants.TEST_IMAGE_URL,
        age = formatAge(66741),
        department = "Grocery",
        profileId = convertProfileId("0x0"),
    ),
)
