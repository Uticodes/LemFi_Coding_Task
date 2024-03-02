package com.example.studentlist.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherHelper {
    fun io(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}
