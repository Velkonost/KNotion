package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.richText.RichTextList

/**
 * See [reference](https://developers.notion.com/reference/block#image-blocks)
 */
interface ImageBlock : Block {
    val image: File
    val caption: RichTextList?
}
