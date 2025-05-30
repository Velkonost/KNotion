package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.model.richText.RichTextList

/**
 * Represents a code block in a Notion page.
 * Code blocks are used to display formatted code snippets with syntax highlighting.
 * They support various programming languages and can be used to share code examples
 * or technical documentation.
 * 
 * Code blocks can contain rich text content and maintain proper code formatting,
 * including indentation and line breaks.
 * 
 * @see Block
 * @see <a href="https://developers.notion.com/reference/block#code-blocks">Code blocks</a>
 */
interface CodeBlock : Block {
    /**
     * The rich text content of the code block.
     * This contains the actual code snippet with any formatting or mentions.
     * If null, the code block is empty.
     */
    val text: RichTextList?

    /**
     * The programming language of the code block.
     * This determines the syntax highlighting rules applied to the code.
     * Common values include "javascript", "python", "java", "kotlin", etc.
     * If the language is not supported, a generic code highlighting will be used.
     */
    val language: String
}
