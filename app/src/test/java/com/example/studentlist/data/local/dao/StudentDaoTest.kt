package com.example.studentlist.data.local.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.studentlist.utils.BaseDaoTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class StudentDaoTest : BaseDaoTest() {

    @Test
    fun `verify that data insertion is successful and returns correct size`() = runTest {

        students?.let { dao.insertAll(it) }

        val studentsFromDb = dao.getAllStudents().first()
        val expectedResult = 3
        val actualResult = studentsFromDb.size
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun insertAndRetrieveStudents() = runTest {

        students?.let { dao.insertAll(it) }

        val allStudents = dao.getAllStudents().first()

        assertEquals(allStudents, students)
    }

}
