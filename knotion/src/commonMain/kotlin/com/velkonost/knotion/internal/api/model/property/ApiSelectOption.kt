package com.velkonost.knotion.internal.api.model.property

import com.velkonost.knotion.internal.api.model.richText.toColor
import com.velkonost.knotion.internal.model.property.SelectOptionImpl
import com.velkonost.knotion.model.property.SelectOption
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiSelectOption(
    val name: String,
    val id: String? = null,
    val color: String,
)

internal fun ApiSelectOption.toModel(): SelectOption = SelectOptionImpl(
    name, id.orEmpty(), color.toColor()
)