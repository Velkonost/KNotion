package com.velkonost.knotion.model.property.spec

/**
 * Represents a date property specification in a Notion database.
 * This property allows users to store and manage dates and date ranges.
 * 
 * Date properties support:
 * - Single dates with optional time
 * - Date ranges (start and end dates)
 * - Time zone support
 * - Relative date references (e.g., "today", "next week")
 * - Date formatting options
 * 
 * Date properties can be used for:
 * - Event scheduling
 * - Deadline tracking
 * - Time-based filtering and sorting
 * - Date calculations in formulas
 * - Calendar views
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#date">Date property</a>
 */
interface DatePropertySpec : PropertySpec
