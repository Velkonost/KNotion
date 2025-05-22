package com.velkonost.knotion.model.emojiOrFile

interface File : EmojiOrFile {
    val name: String?
    val url: String
}

fun File(url: String): File = FileImpl(name = null, url = url)
