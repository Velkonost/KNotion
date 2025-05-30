package com.velkonost.knotion.model.exception

/**
 * Base exception type for all errors thrown by the Notion client library.
 *
 * This exception is used as a superclass for more specific Notion-related exceptions.
 * It wraps the underlying cause of the error, if available.
 */
open class NotionClientException(override val cause: Throwable?) : Exception(cause)
