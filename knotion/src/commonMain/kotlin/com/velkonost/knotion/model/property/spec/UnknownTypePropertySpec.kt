package com.velkonost.knotion.model.property.spec

/**
 * Represents a property specification of an unknown type in a Notion database.
 * This interface is used when the Notion API returns a property type that is not
 * yet supported by this library.
 * 
 * Unknown type properties are preserved in the database but may not have full
 * functionality in this library. The [type] field can be used to identify the
 * actual property type for debugging or future implementation.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object">Property object</a>
 */
interface UnknownTypePropertySpec : PropertySpec {
    val type: String?
}
