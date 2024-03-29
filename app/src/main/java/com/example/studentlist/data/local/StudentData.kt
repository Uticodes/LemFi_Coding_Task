package com.example.studentlist.data.local

import com.example.studentlist.data.remote.dto.Student
import com.example.studentlist.utils.convertProfileId
import com.example.studentlist.utils.formatAge

data class StudentData(
    val id: String? = null,
    val name: String? = null,
    val avatar: String? = null,
    val age: Int = 0,
    val department: String? = null,
    val profileId: String? = null,
) {
    companion object {
        fun fromStudents(students: List<Student>): List<StudentData> {
            return students.map {
                StudentData(
                    id = it.id,
                    name = it.name,
                    avatar = it.avatar,
                    age = formatAge(it.age),
                    department = it.department,
                    profileId = it.profileId?.let { id -> convertProfileId(id) }
                )
            }
        }
    }
}
