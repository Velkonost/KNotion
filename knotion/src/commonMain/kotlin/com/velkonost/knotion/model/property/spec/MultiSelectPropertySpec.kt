package com.velkonost.knotion.model.property.spec

import com.velkonost.knotion.model.property.SelectOption
import com.velkonost.knotion.model.property.spec.PropertySpec

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface MultiSelectPropertySpec : PropertySpec {
    val options: List<SelectOption>
}
