package com.velkonost.knotion.internal.network.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal data class ErrorResponse(
    val code: String,
    val message: String,
    val status: Int? = null,
    val details: JsonObject? = null,
)