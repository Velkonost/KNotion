package com.velkonost.knotion.internal.api.model.emojiOrFile

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/emoji-object).
 */
@Serializable
internal data class ApiEmoji(
    val emoji: String,
)
