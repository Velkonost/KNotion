package com.velkonost.knotion.model.page.block

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
interface EmbedBlock: Block {
    val url: String
}
