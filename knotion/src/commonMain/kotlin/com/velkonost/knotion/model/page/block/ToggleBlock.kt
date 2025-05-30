package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.richText.RichTextList

/**
 * Represents a toggle block in a Notion page.
 * Toggle blocks are collapsible sections that can contain other blocks as children.
 * They are useful for organizing content that can be expanded or collapsed by users.
 * 
 * When collapsed, only the toggle's text is visible. When expanded, all child blocks
 * are displayed below the toggle text.
 * 
 * @see Block
 * @see <a href="https://developers.notion.com/reference/block#toggle-blocks">Toggle blocks</a>
 */
interface ToggleBlock : Block {
    /**
     * The rich text content that serves as the toggle's header.
     * This text is always visible and acts as the clickable area to expand/collapse the block.
     * If null, the toggle has no visible header text.
     */
    val text: RichTextList?
}
