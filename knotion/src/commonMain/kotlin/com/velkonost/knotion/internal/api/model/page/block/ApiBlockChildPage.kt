package com.velkonost.knotion.internal.api.model.page.block

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
@Serializable
internal data class ApiBlockChildPage(
    val title: String,
)
