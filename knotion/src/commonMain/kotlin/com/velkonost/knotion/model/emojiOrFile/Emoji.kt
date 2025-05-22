
package com.velkonost.knotion.model.emojiOrFile

import com.velkonost.knotion.internal.model.emojiOrFile.EmojiImpl

/**
 * See [Reference](https://developers.notion.com/reference/emoji-object).
 */
interface Emoji : EmojiOrFile {
    val value: String
}

fun Emoji(value: String): Emoji = EmojiImpl(value)
