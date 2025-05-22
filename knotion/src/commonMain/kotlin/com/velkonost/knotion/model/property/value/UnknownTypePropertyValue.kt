package com.velkonost.knotion.model.property.value

/**
 * This type is returned when a Property Value of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface UnknownTypePropertyValue : PropertyValue<Nothing?> {
    val type: String
}
