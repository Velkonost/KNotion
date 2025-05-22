package com.velkonost.knotion.internal.model.database

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Reference
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.property.spec.PropertySpec
import com.velkonost.knotion.model.richText.RichTextList

internal data class DatabaseImpl(
    override val id: UuidString,
    override val parent: Reference,
    override val title: RichTextList,
    override val propertySpecs: List<PropertySpec>,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val icon: EmojiOrFile?,
    override val cover: File?,
) : Database
