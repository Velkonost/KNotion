package com.velkonost.knotion.model.property.spec

/**
 * Represents a created time property specification in a Notion database.
 * This property automatically tracks and displays when a page was created.
 * 
 * The created time is set when the page is first created and cannot be changed
 * afterward. This property cannot be manually edited.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#created-time">Created time property</a>
 */
interface CreatedTimePropertySpec : PropertySpec
