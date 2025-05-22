package com.velkonost.knotion.internal.api.model.search.request

import com.velkonost.knotion.internal.api.model.search.ApiSearchFilter
import com.velkonost.knotion.internal.api.model.search.ApiSearchSort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-search).
 */
@Serializable
internal data class SearchRequest(
    val query: String? = null,
    val sort: ApiSearchSort? = null,
    val filter: ApiSearchFilter,
    @SerialName("start_cursor")
    val startCursor: String? = null,
)
