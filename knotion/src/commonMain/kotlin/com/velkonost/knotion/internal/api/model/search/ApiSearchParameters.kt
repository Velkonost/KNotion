package com.velkonost.knotion.internal.api.model.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-search).
 */
@Serializable
internal data class ApiSearchParameters(
    val query: String? = null,
    val sort: ApiSearchSort? = null,
    val filter: ApiSearchFilter,
    @SerialName("start_cursor")
    val startCursor: String? = null,
)
