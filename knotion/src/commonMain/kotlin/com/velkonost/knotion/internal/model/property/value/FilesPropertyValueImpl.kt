package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.property.value.FilesPropertyValue

internal data class FilesPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: List<File>,
) : FilesPropertyValue
