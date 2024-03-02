package com.example.studentlist.utils

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.studentlist.data.local.StudentDataBase
import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.dto.Student
import com.squareup.moshi.Types
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.io.IOException

abstract class BaseDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val type = Types.newParameterizedType(List::class.java, Student::class.java)
    val students =
        TestUtil.parseJsonFileToObject<List<Student>>("sample-student.json", type)
    private lateinit var db: StudentDataBase
    lateinit var dao: StudentDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, StudentDataBase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.studentDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}
