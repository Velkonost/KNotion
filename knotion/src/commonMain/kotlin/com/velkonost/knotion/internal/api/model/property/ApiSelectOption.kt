package com.velkonost.knotion.internal.api.model.property

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiSelectOption(
    val name: String,
    val id: String? = null,
    val color: String,
)
