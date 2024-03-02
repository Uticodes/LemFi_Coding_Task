package com.example.studentlist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.dto.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}