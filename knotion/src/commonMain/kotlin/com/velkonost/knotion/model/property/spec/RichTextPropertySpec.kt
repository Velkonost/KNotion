package com.velkonost.knotion.model.property.spec

/**
 * Represents a rich text property specification in a Notion database.
 * This property allows users to enter formatted text with various styling options,
 * including bold, italic, code, links, and mentions.
 * 
 * Rich text properties support:
 * - Text formatting (bold, italic, strikethrough, code)
 * - Links to external websites
 * - Mentions of pages, databases, dates, and users
 * - Inline equations
 * 
 * The text can be styled using the Notion interface or programmatically through
 * the API. Rich text properties can be used for filtering and sorting database views.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#rich-text">Rich text property</a>
 */
interface RichTextPropertySpec : PropertySpec
