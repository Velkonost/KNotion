package com.velkonost.knotion.internal.api.model.search

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-search).
 */
@Serializable
internal data class ApiSearchFilter(
    val property: String,
    val value: String,
)
