package com.velkonost.knotion.model.property.spec

/**
 * Represents an email property specification in a Notion database.
 * This property allows users to store and validate email addresses.
 * 
 * Email properties have the following features:
 * - Automatic validation of email address format
 * - Clickable email addresses that open the default email client
 * - Support for filtering and sorting in database views
 * - Can be used in formulas and rollups
 * 
 * The email addresses are stored as plain text but are displayed as clickable
 * links in the Notion interface.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#email">Email property</a>
 */
interface EmailPropertySpec : PropertySpec
