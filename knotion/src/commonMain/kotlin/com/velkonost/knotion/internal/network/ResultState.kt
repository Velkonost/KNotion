package com.velkonost.knotion.internal.network

import com.velkonost.knotion.internal.network.model.ErrorResponse
import com.velkonost.knotion.model.exception.NotionClientRequestException
import kotlinx.coroutines.CompletableDeferred

internal sealed class ResultState<out T> {
    data class Success<out T : Any?>(val data: T) : ResultState<T>()
    data class Failure(
        val throwable: Throwable? = null,
        val code: Int? = null,
        val message: ErrorResponse? = null,
    ) : ResultState<Nothing>()

    data object Loading : ResultState<Nothing>()
}

internal inline fun <T : Any?> ResultState<T>.isLoading(crossinline action: (isLoading: Boolean) -> Unit): ResultState<T> {
    if (this is ResultState.Loading) action(true) else action(false)
    return this
}

internal inline fun <T : Any?> ResultState<T>.onSuccess(crossinline action: (T) -> Unit): ResultState<T> {
    if (this is ResultState.Success) action(this.data)
    return this
}

internal inline fun <T : Any?> ResultState<T>.onFailure(crossinline action: (throwable: Throwable?, error: ErrorResponse?) -> Unit): ResultState<T> {
    if (this is ResultState.Failure) action(this.throwable, this.message)
    return this
}

internal fun <T : Any> CompletableDeferred<T>.handleError(throwable: Throwable?, error: ErrorResponse? = null) {
    val exception = NotionClientRequestException(throwable).apply {
        error?.let { withError(it) }
    }
    completeExceptionally(exception)
}