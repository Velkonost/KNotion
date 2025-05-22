package com.velkonost.knotion.internal.api.model.property.spec

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jraf.klibnotion.internal.api.model.property.spec.*

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiPropertySpec(
    val id: String? = null,
    val type: String? = null,
    val number: ApiPropertySpecNumber? = null,
    val select: ApiPropertySpecSelect? = null,
    @SerialName("multi_select")
    val multiSelect: ApiPropertySpecMultiSelect? = null,
    val formula: ApiPropertySpecFormula? = null,
    val relation: ApiPropertySpecRelation? = null,
    val rollup: ApiPropertySpecRollup? = null,
    val title: ApiEmpty? = null,
    val checkbox: ApiEmpty? = null,
    @SerialName("created_by")
    val createdBy: ApiEmpty? = null,
    @SerialName("created_time")
    val createdTime: ApiEmpty? = null,
    val date: ApiEmpty? = null,
    val email: ApiEmpty? = null,
    val files: ApiEmpty? = null,
    @SerialName("last_edited_by")
    val lastEditedBy: ApiEmpty? = null,
    @SerialName("last_edited_time")
    val lastEditedTime: ApiEmpty? = null,
    val people: ApiEmpty? = null,
    @SerialName("phone_number")
    val phoneNumber: ApiEmpty? = null,
    @SerialName("rich_text")
    val richText: ApiEmpty? = null,
    val url: ApiEmpty? = null,
)

@Serializable
internal class ApiEmpty
