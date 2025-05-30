package com.velkonost.knotion.model.property.spec

/**
 * Represents a title property specification in a Notion database.
 * This is a special property type that is required for every database and serves
 * as the primary identifier for each page.
 * 
 * Title properties have the following characteristics:
 * - Every database must have exactly one title property
 * - The title property cannot be deleted or converted to another type
 * - Title values can contain rich text with formatting and mentions
 * - Title values are used as the page name in the Notion interface
 * - Title values are used as the default sort order in database views
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#title">Title property</a>
 */
interface TitlePropertySpec : PropertySpec
