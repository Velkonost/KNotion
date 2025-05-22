package com.velkonost.knotion.internal.model.page

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Reference
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.property.value.PropertyValue

internal data class PageImpl(
    override val id: UuidString,
    override val parent: Reference,
    override val propertyValues: List<PropertyValue<*>>,
    override val archived: Boolean,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val url: String,
    override val icon: EmojiOrFile?,
    override val cover: File?,
) : Page
