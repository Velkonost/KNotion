package com.velkonost.knotion.model.property.spec

/**
 * Represents a last edited time property specification in a Notion database.
 * This property automatically tracks and displays when a page was last modified.
 * 
 * The last edited time is automatically updated by Notion whenever any property
 * or content of the page is changed. This property cannot be manually edited.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#last-edited-time">Last edited time property</a>
 */
interface LastEditedTimePropertySpec : PropertySpec
