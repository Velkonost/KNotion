package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.richText.RichTextList

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
interface QuoteBlock : Block {
    val text: RichTextList?
}
