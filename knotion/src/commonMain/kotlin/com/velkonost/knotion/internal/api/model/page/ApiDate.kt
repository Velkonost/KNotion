package com.velkonost.knotion.internal.api.model.page

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#date-property-values).
 */
@Serializable
internal data class ApiDate(
    val start: String,
    val end: String? = null,
)
