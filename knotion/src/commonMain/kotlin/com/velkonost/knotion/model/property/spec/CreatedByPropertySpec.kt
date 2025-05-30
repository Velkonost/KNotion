package com.velkonost.knotion.model.property.spec

/**
 * Represents a created by property specification in a Notion database.
 * This property automatically tracks and displays which user created each page.
 * 
 * Created by properties have the following characteristics:
 * - Automatically set when a page is created
 * - Cannot be manually edited
 * - Shows the user's name and avatar
 * - Updates automatically if the creator's information changes
 * - Can be used for filtering and sorting
 * 
 * This property is useful for:
 * - Tracking content ownership
 * - Auditing page creation
 * - Filtering by content creator
 * - Team collaboration tracking
 * - User activity monitoring
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#created-by">Created by property</a>
 */
interface CreatedByPropertySpec : PropertySpec
