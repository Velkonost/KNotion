package com.velkonost.knotion.model.exception

import com.velkonost.knotion.internal.network.model.ErrorResponse
import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

/**
 * Exception thrown when a Notion API request fails with an error response.
 *
 * This exception wraps details about the error returned by the Notion API, including the error code,
 * message, HTTP status, and any additional details provided by the API.
 *
 * @property cause The underlying cause of the error (e.g., a network or HTTP exception).
 * @property code The Notion API error code, or "unexpected" if not available.
 * @property message The error message returned by the Notion API, or a generic message if not available.
 * @property detailsJson Additional error details as a JSON string, if provided by the API.
 * @property status The HTTP status code returned by the Notion API, if available.
 */
class NotionClientRequestException(
    override val cause: Throwable?,
) : NotionClientException(cause) {
    private var notionError: NotionError? = null

    private val code: String = notionError?.code ?: "unexpected"
    override val message: String = notionError?.message ?: "Unexpected error: ${cause?.message}"
    private val detailsJson: String = notionError?.details?.toString() ?: "{}"
    private val status: Int? = notionError?.status

    /**
     * Populates this exception with error details from a Notion API [ErrorResponse].
     */
    internal fun withError(value: ErrorResponse) {
        notionError = NotionError.fromResponse(value)
    }

    override fun toString(): String {
        return "NotionClientRequestException(status=$status, code='$code', message='$message', detailsJson='$detailsJson')"
    }
}

/**
 * Internal data class representing a Notion API error response.
 *
 * @property code The error code returned by the Notion API.
 * @property message The error message returned by the Notion API.
 * @property status The HTTP status code, if available.
 * @property details Additional error details as a JSON object, if provided.
 */
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
