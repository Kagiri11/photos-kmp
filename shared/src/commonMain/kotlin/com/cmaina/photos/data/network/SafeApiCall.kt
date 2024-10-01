package com.cmaina.photos.data.network

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

suspend inline fun <T : Any, reified R : Any> safeApiCall(
    apiCall: () -> T
) =
    try {
        Result.success(apiCall.invoke())
    } catch (e: Exception) {
        Result.failure(e)
    }

class InOut<in T : Any, out R : Any>(val item: @UnsafeVariance T) {
    suspend fun apiCall(
        response: HttpResponse,
        mapper: suspend (@UnsafeVariance T) -> @UnsafeVariance R
    ): Result<@UnsafeVariance R> {
        return when (response.status.value) {
            200 -> Result.success(mapper.invoke(item))
            else -> Result.failure(Exception(response.bodyAsText()))
        }
    }
}

