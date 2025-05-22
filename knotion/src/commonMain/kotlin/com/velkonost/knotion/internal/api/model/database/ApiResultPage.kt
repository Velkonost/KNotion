package com.velkonost.knotion.internal.api.model.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/pagination).
 */
@Serializable
internal data class ApiResultPage<T : Any>(
    val results: List<T>,
    @SerialName("next_cursor")
    val nextCursor: String?,
)
