package com.velkonost.knotion.model.page.block

/**
 * This type is returned when a Block of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/block).
 */
interface UnknownTypeBlock : Block {
    val type: String
}
