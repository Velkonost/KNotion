package com.velkonost.knotion.model.database

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Reference
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.property.spec.PropertySpec
import com.velkonost.knotion.model.richText.RichTextList

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface Database {
    val id: UuidString
    val parent: Reference
    val title: RichTextList
    val propertySpecs: List<PropertySpec>
    val created: Timestamp
    val lastEdited: Timestamp
    val icon: EmojiOrFile?
    val cover: File?
}
