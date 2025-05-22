package com.velkonost.knotion.internal.api.model.page.request

import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File

internal data class UpdatePageRequest(
    val properties: List<PropertyStringValue>,
    val icon: EmojiOrFile? = null,
    val cover: File? = null,
)