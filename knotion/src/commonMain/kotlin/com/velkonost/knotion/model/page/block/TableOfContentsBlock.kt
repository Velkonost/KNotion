package com.velkonost.knotion.model.page.block

/**
 * Represents a table of contents block in a Notion page.
 * A table of contents block automatically generates a hierarchical list of all headings in the page,
 * making it easy to navigate through the content.
 * 
 * The table of contents is automatically updated as headings are added, removed, or modified in the page.
 * It cannot be directly edited by users or through the API.
 * 
 * @see Block
 * @see <a href="https://developers.notion.com/reference/block#table-of-contents-blocks">Table of contents blocks</a>
 */
interface TableOfContentsBlock : Block
