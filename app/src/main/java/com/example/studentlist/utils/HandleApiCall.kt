package com.example.studentlist.utils

import retrofit2.Response
import timber.log.Timber

suspend fun <T> performApiCall(
    apiCall: suspend () -> Response<T>,
): Result<T?> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            Result.success(response.body())
        } else {
            Timber.e("API Error: ${response.message()}")
            Result.failure(FetchExceptions(message = response.message()))
        }
    } catch (e: Exception) {
        Timber.e(e, e.message)
        Result.failure(e)
    }
}
