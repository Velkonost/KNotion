package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
@Serializable
internal data class ApiBlockCode(
    val language: String,
    val text: List<ApiRichText>,
)
