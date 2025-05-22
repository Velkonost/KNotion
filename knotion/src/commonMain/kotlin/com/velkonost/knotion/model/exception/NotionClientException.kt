package com.velkonost.knotion.model.exception

open class NotionClientException(override val cause: Throwable?) : Exception(cause)
