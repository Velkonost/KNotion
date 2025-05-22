package com.velkonost.knotion.model.exception

import com.velkonost.knotion.internal.network.model.ErrorResponse
import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class NotionClientRequestException(
    override val cause: Throwable?,
) : NotionClientException(cause) {
    private var notionError: NotionError? = null

    private val code: String = notionError?.code ?: "unexpected"
    override val message: String = notionError?.message ?: "Unexpected error: ${cause?.message}"
    private val detailsJson: String = notionError?.details?.toString() ?: "{}"
    private val status: Int? = notionError?.status

    internal fun withError(value: ErrorResponse) {
        notionError = NotionError.fromResponse(value)
    }

    override fun toString(): String {
        return "NotionClientRequestException(status=$status, code='$code', message='$message', detailsJson='$detailsJson')"
    }
}

@Serializable
private data class NotionError(
    val code: String,
    val message: String,
    val status: Int? = null,
    val details: JsonObject? = null,
) {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }

        fun fromResponse(value: ErrorResponse): NotionError = NotionError(
            code = value.code,
            message = value.message,
            status = value.status,
            details = value.details,
        )
    }
}
