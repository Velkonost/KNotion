package com.velkonost.knotion.internal.api.model.emojiOrFile

import kotlinx.serialization.Serializable

/**
 * See
 * - [Reference](https://developers.notion.com/reference/file-object)
 */
@Serializable
internal data class ApiFile(
    val url: String,
)
