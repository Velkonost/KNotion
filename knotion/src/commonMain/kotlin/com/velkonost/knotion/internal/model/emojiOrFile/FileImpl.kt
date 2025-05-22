package com.velkonost.knotion.internal.model.emojiOrFile

import com.velkonost.knotion.model.emojiOrFile.File

internal data class FileImpl(
    override val name: String?,
    override val url: String,
) : File
