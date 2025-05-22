package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.richText.RichTextList

/**
 * See [reference](https://developers.notion.com/reference/block#video-blocks)
 */
interface VideoBlock : Block {
    val video: File
    val caption: RichTextList?
}
