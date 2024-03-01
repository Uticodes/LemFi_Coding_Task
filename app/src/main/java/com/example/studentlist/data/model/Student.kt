package com.example.studentlist.data.model

data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val department: String,
    val avatar: String,

)

val listOfStudents = List(10) {
    Student(
        id = "$it",
        name = "Student ${it + 1}",
        age = 17 + it,
        department = "Biochemistry",
        avatar = "NN/B${it + 19}/281"
    )
}