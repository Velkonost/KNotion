package com.velkonost.knotion.internal.model.emojiOrFile

import com.velkonost.knotion.model.emojiOrFile.Emoji

internal data class EmojiImpl(
    override val value: String,
) : Emoji
