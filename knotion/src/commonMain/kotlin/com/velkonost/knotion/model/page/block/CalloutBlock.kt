package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.richText.RichTextList

interface CalloutBlock : Block {
    val text: RichTextList?
    val icon: EmojiOrFile?
}
