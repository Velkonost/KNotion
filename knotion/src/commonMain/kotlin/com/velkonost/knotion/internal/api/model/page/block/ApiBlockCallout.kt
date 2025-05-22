package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiEmojiOrFile
import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiBlockCallout(
    val text: List<ApiRichText>,
    val icon: ApiEmojiOrFile
)
