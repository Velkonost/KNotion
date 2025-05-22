package com.velkonost.knotion.internal.api.model.property.value

import com.velkonost.knotion.internal.api.model.page.ApiDate
import com.velkonost.knotion.internal.api.model.page.toDateModel
import com.velkonost.knotion.internal.api.model.page.toModel
import com.velkonost.knotion.internal.api.model.property.ApiSelectOption
import com.velkonost.knotion.internal.api.model.property.toModel
import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import com.velkonost.knotion.internal.api.model.richText.toModel
import com.velkonost.knotion.internal.api.model.user.ApiUser
import com.velkonost.knotion.internal.api.model.user.toModel
import com.velkonost.knotion.internal.model.property.value.*
import com.velkonost.knotion.internal.model.property.value.formula.*
import com.velkonost.knotion.internal.model.property.value.rollup.ArrayRollupPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.rollup.DateRollupPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.rollup.NumberRollupPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.rollup.UnknownTypeRollupPropertyValueImpl
import com.velkonost.knotion.model.property.value.FormulaPropertyValue
import com.velkonost.knotion.model.property.value.PropertyValue
import com.velkonost.knotion.model.property.value.RollupPropertyValue
import com.velkonost.knotion.model.richText.RichTextList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
internal data class ApiPropertyValue(
    /**
     * Can be omitted in case of rollup array properties.
     */
    val id: String = "",

    val type: String,
    @SerialName("rich_text")
    val richText: List<ApiRichText>? = null,
    val number: String? = null,
    val select: ApiSelectOption? = null,
    @SerialName("multi_select")
    val multiSelect: List<ApiSelectOption>? = null,
    val date: ApiDate? = null,
    val formula: ApiPropertyValueFormula? = null,
    val relation: List<ApiPropertyValueRelation>? = null,
    val rollup: ApiPropertyValueRollup? = null,
    val title: List<ApiRichText>? = null,
    val people: List<ApiUser>? = null,
    val files: List<ApiPropertyValueFile>? = null,
    val checkbox: Boolean? = null,
    val url: String? = null,
    val email: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("created_time")
    val createdTime: String? = null,
    @SerialName("created_by")
    val createdBy: ApiUser? = null,
    @SerialName("last_edited_time")
    val lastEditedTime: String? = null,
    @SerialName("last_edited_by")
    val lastEditedBy: ApiUser? = null,
)

internal fun Pair<String, ApiPropertyValue>.toFormulaModel(): FormulaPropertyValue<*> {
    val (name, apiPropertyValue) = this
    val id = apiPropertyValue.id
    val formula = apiPropertyValue.formula!!
    return when (val type = formula.type) {
        "string" -> StringFormulaPropertyValueImpl(
            id = id,
            name = name,
            value = formula.string
        )
        "number" -> NumberFormulaPropertyValueImpl(
            id = id,
            name = name,
            value = formula.number?.toDouble()
        )
        "boolean" -> BooleanFormulaPropertyValueImpl(
            id = id,
            name = name,
            value = formula.boolean!!,
        )
        "date" -> DateFormulaPropertyValueImpl(
            id = id,
            name = name,
            value = formula.date?.toModel()
        )
        else -> UnknownTypeFormulaPropertyValueImpl(
            id = id,
            name = name,
            type = type,
        )
    }
}

internal fun Pair<String, ApiPropertyValue>.toRollupModel(): RollupPropertyValue<*> {
    val (name, apiPropertyValue) = this
    val id = apiPropertyValue.id
    val rollup = apiPropertyValue.rollup!!
    return when (val type = rollup.type) {
        "number" -> NumberRollupPropertyValueImpl(
            id = id,
            name = name,
            value = rollup.number?.toDouble()
        )
        "date" -> DateRollupPropertyValueImpl(
            id = id,
            name = name,
            value = rollup.date?.toModel()
        )
        "array" -> ArrayRollupPropertyValueImpl(
            id = id,
            name = name,
            value = rollup.array?.map { ("" to it).toModel() }
        )

        else -> UnknownTypeRollupPropertyValueImpl(
            id = id,
            name = name,
            type = type,
        )
    }
}

internal fun Pair<String, ApiPropertyValue>.toModel(): PropertyValue<*> {
    val (name, apiPropertyValue) = this
    val id = apiPropertyValue.id
    return when (val type = apiPropertyValue.type) {
        "rich_text" -> RichTextPropertyValueImpl(
            id = id,
            name = name,
            value = RichTextList().apply {
                apiPropertyValue.richText?.map { it.toModel() }?.let { value ->
                    items.addAll(value)
                }
            }
        )

        "number" -> NumberPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.number?.toDouble()
        )

        "select" -> SelectPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.select?.toModel()
        )

        "multi_select" -> MultiSelectPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.multiSelect!!.map { it.toModel() }
        )

        "date" -> DatePropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.date?.toModel()
        )

        "formula" -> this.toFormulaModel()
        "relation" -> RelationPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.relation!!.map { it.id }
        )

        "rollup" -> this.toRollupModel()
        "title" -> TitlePropertyValueImpl(
            id = id,
            name = name,
            value = RichTextList().apply {
                apiPropertyValue.title?.map { it.toModel() }?.let { value ->
                    items.addAll(value)
                }
            }
        )

        "people" -> PeoplePropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.people!!.map { it.toModel() }
        )

        "files" -> FilesPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.files!!.map { it.toModel() }
        )

        "checkbox" -> CheckboxPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.checkbox!!
        )

        "url" -> UrlPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.url
        )

        "email" -> EmailPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.email
        )

        "phone_number" -> PhoneNumberPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.phoneNumber
        )

        "created_time" -> CreatedTimePropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.createdTime!!.toDateModel()
        )

        "created_by" -> CreatedByPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.createdBy!!.toModel()
        )

        "last_edited_time" -> LastEditedTimePropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.lastEditedTime!!.toDateModel()
        )

        "last_edited_by" -> LastEditedByPropertyValueImpl(
            id = id,
            name = name,
            value = apiPropertyValue.lastEditedBy!!.toModel()
        )

        else -> UnknownTypePropertyValueImpl(
            id = id,
            name = name,
            type = type,
        )
    }
}
