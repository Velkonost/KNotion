package com.velkonost.knotion.model.property.spec

/**
 * Represents a phone number property specification in a Notion database.
 * This property allows users to store and manage phone numbers in various formats.
 * 
 * Phone number properties support:
 * - International phone number formats
 * - Clickable phone numbers that open the default phone app
 * - Filtering and sorting by phone numbers
 * - Integration with contact management
 * - Use in formulas and rollups
 * 
 * Common use cases include:
 * - Contact information
 * - Customer records
 * - Support contact details
 * - Team member contact info
 * - Emergency contact lists
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#phone-number">Phone number property</a>
 */
interface PhoneNumberPropertySpec : PropertySpec
