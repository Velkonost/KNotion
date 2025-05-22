package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.model.property.SelectOption

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface MultiSelectPropertyValue : PropertyValue<List<SelectOption>>
