package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.richText.RichTextList

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
interface BulletedListItemBlock : Block {
    val text: RichTextList?
}
