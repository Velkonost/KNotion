package com.velkonost.knotion.model.property.spec

/**
 * Represents a URL property specification in a Notion database.
 * This property allows users to store and link to external web addresses.
 * 
 * URL properties can contain any valid web address, including:
 * - HTTP and HTTPS URLs
 * - Relative URLs
 * - Protocol-relative URLs
 * 
 * The URLs are automatically clickable in the Notion interface and can be used
 * for filtering and sorting database views.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#url">URL property</a>
 */
interface UrlPropertySpec : PropertySpec
