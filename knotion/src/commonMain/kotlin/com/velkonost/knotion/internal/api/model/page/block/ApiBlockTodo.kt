package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.richtext.ApiRichText
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
@Serializable
internal data class ApiBlockTodo(
    val checked: Boolean,
    val text: List<ApiRichText>,
)
