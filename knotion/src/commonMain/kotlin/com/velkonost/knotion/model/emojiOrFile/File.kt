package com.velkonost.knotion.model.emojiOrFile

import com.velkonost.knotion.internal.model.emojiOrFile.FileImpl

interface File : EmojiOrFile {
    val name: String?
    val url: String
}

fun File(url: String): File = FileImpl(name = null, url = url)
