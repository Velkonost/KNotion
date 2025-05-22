package com.velkonost.knotion.model.property.spec

/**
 * This type is returned when a Property Spec of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface UnknownTypePropertySpec : PropertySpec {
    val type: String?
}
