package com.example.studentlist.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.*

class DispatcherHelperImplTest : DispatcherHelper {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()
    override fun io(): CoroutineDispatcher = testDispatcher

    override fun main(): CoroutineDispatcher = testDispatcher
}