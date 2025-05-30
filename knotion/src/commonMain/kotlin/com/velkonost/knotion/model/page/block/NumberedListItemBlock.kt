package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.richText.RichTextList

/**
 * Represents a numbered list item block in a Notion page.
 * Numbered list items are part of an ordered list, where each item is automatically numbered
 * based on its position in the list. The numbering is handled automatically by Notion.
 * 
 * Numbered list items can contain rich text content and can be nested within other blocks
 * to create hierarchical lists.
 * 
 * @see Block
 * @see <a href="https://developers.notion.com/reference/block#numbered-list-item-blocks">Numbered list item blocks</a>
 */
interface NumberedListItemBlock : Block {
    /**
     * The rich text content of the numbered list item.
     * This can include formatted text, mentions, and other rich text elements.
     * If null, the list item is empty.
     */
    val text: RichTextList?
}
