package com.velkonost.knotion.internal.api.model.database.request

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.property.spec.PropertySpecList
import com.velkonost.knotion.model.richText.RichTextList
import kotlinx.serialization.Serializable

@Serializable
internal data class CreateDatabaseRequest(
    val parentPageId: UuidString,
    val title: RichTextList,
    val icon: EmojiOrFile?,
    val cover: File?,
    val properties: PropertySpecList,
)