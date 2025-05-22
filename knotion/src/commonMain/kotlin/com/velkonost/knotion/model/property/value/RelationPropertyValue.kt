package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.extension.UuidString

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface RelationPropertyValue : PropertyValue<List<UuidString>>
