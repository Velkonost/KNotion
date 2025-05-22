package com.velkonost.knotion.model.page

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Reference
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile

/**
 * See [Reference](https://developers.notion.com/reference/page).
 */
interface Page {
    val id: UuidString
    val parent: Reference
    val propertyValues: List<PropertyValue<*>>
    val archived: Boolean
    val created: Timestamp
    val lastEdited: Timestamp
    val url: String
    val icon: EmojiOrFile?
    val cover: File?
}