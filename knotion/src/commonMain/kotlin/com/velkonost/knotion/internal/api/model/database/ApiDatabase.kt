package com.velkonost.knotion.internal.api.model.database

import com.velkonost.knotion.internal.api.model.ApiReference
import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiEmojiOrFile
import com.velkonost.knotion.internal.api.model.emojiOrFile.toModel
import com.velkonost.knotion.internal.api.model.property.spec.ApiPropertySpec
import com.velkonost.knotion.internal.api.model.property.spec.toFunctionModel
import com.velkonost.knotion.internal.api.model.property.toModel
import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import com.velkonost.knotion.internal.api.model.richText.toModel
import com.velkonost.knotion.internal.api.model.toDatabaseModel
import com.velkonost.knotion.internal.model.database.DatabaseImpl
import com.velkonost.knotion.internal.model.property.spec.*
import com.velkonost.knotion.internal.utils.DateUtils
import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.property.spec.NumberPropertySpec
import com.velkonost.knotion.model.property.spec.PropertySpec
import com.velkonost.knotion.model.richText.RichTextList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiDatabase(
    val id: String,
    val parent: ApiReference,
    val title: List<ApiRichText>,
    val properties: Map<String, ApiPropertySpec>,
    @SerialName("created_time")
    val createdTime: String,
    @SerialName("last_edited_time")
    val lastEditedTime: String,
    val icon: ApiEmojiOrFile?,
    // Technically this can only be "file" or "external", never "emoji"
    val cover: ApiEmojiOrFile?,
)

internal fun ApiDatabase.toModel(): Database = DatabaseImpl(
    id = id,
    parent = parent.toDatabaseModel(),
    title = RichTextList().apply { items.addAll(title.map { it.toModel() }) },
    propertySpecs = properties.map { (it.key to it.value).toModel() },
    created = DateUtils.parse(createdTime),
    lastEdited = DateUtils.parse(lastEditedTime),
    icon = icon?.toModel(),
    cover = cover?.toModel()
)

internal fun Pair<String, ApiPropertySpec>.toModel(): PropertySpec {
    val (name, apiPropertySpec) = this
    val id = apiPropertySpec.id!!
    return when (apiPropertySpec.type) {
        "title" -> TitlePropertySpecImpl(name = name, id = id)
        "rich_text" -> RichTextPropertySpecImpl(name = name, id = id)
        "number" -> NumberPropertySpecImpl(
            name = name,
            id = id,
            format = apiPropertySpec.number!!.format.toNumberModel()

        )
        "select" -> SelectPropertySpecImpl(
            name = name,
            id = id,
            options = apiPropertySpec.select!!.options.map { it.toModel() }
        )
        "multi_select" -> MultiSelectPropertySpecImpl(
            name = name,
            id = id,
            options = apiPropertySpec.multiSelect!!.options.map { it.toModel() }
        )

        "date" -> DatePropertySpecImpl(name = name, id = id)
        "people" -> PeoplePropertySpecImpl(name = name, id = id)
        "files" -> FilesPropertySpecImpl(name = name, id = id)
        "checkbox" -> CheckboxPropertySpecImpl(name = name, id = id)
        "url" -> UrlPropertySpecImpl(name = name, id = id)
        "email" -> EmailPropertySpecImpl(name = name, id = id)
        "phone_number" -> PhoneNumberPropertySpecImpl(name = name, id = id)
        "formula" -> FormulaPropertySpecImpl(
            name = name,
            id = id,
            expression = apiPropertySpec.formula!!.expression
        )
        "relation" -> RelationPropertySpecImpl(
            name = name,
            id = id,
            databaseId = apiPropertySpec.relation!!.databaseId,
            syncedPropertyName = apiPropertySpec.relation.syncedPropertyName,
            syncedPropertyId = apiPropertySpec.relation.syncedPropertyId
        )
        "rollup" -> RollupPropertySpecImpl(
            name = name,
            id = id,
            relationPropertyName = apiPropertySpec.rollup!!.relationPropertyName,
            relationPropertyId = apiPropertySpec.rollup.relationPropertyId,
            rollupPropertyName = apiPropertySpec.rollup.rollupPropertyName,
            rollupPropertyId = apiPropertySpec.rollup.rollupPropertyId,
            function = apiPropertySpec.rollup.function.toFunctionModel()
        )
        "created_time" -> CreatedTimePropertySpecImpl(name = name, id = id)
        "created_by" -> CreatedByPropertySpecImpl(name = name, id = id)
        "last_edited_time" -> LastEditedTimePropertySpecImpl(name = name, id = id)
        "last_edited_by" -> LastEditedByPropertySpecImpl(name = name, id = id)
        else -> UnknownTypePropertySpecImpl(name = name, id = id, type = apiPropertySpec.type)
    }
}

internal fun String.toNumberModel(): NumberPropertySpec.NumberFormat {
    return when (this) {
        "number" -> NumberPropertySpec.NumberFormat.NUMBER
        "number_with_commas" -> NumberPropertySpec.NumberFormat.NUMBER_WITH_COMMAS
        "percent" -> NumberPropertySpec.NumberFormat.PERCENT
        "dollar" -> NumberPropertySpec.NumberFormat.DOLLAR
        "euro" -> NumberPropertySpec.NumberFormat.EURO
        "pound" -> NumberPropertySpec.NumberFormat.POUND
        "yen" -> NumberPropertySpec.NumberFormat.YEN
        "ruble" -> NumberPropertySpec.NumberFormat.RUBLE
        "rupee" -> NumberPropertySpec.NumberFormat.RUPEE
        "won" -> NumberPropertySpec.NumberFormat.WON
        "yuan" -> NumberPropertySpec.NumberFormat.YUAN
        "canadian_dollar" -> NumberPropertySpec.NumberFormat.CANADIAN_DOLLAR
        "real" -> NumberPropertySpec.NumberFormat.REAL
        "lira" -> NumberPropertySpec.NumberFormat.LIRA
        "rupiah" -> NumberPropertySpec.NumberFormat.RUPIAH
        "franc" -> NumberPropertySpec.NumberFormat.FRANC
        "hong_kong_dollar" -> NumberPropertySpec.NumberFormat.HONG_KONG_DOLLAR
        "new_zealand_dollar" -> NumberPropertySpec.NumberFormat.NEW_ZEALAND_DOLLAR
        "krona" -> NumberPropertySpec.NumberFormat.KRONA
        "norwegian_krone" -> NumberPropertySpec.NumberFormat.NORWEGIAN_KRONE
        "mexican_peso" -> NumberPropertySpec.NumberFormat.MEXICAN_PESO
        "rand" -> NumberPropertySpec.NumberFormat.RAND
        "new_taiwan_dollar" -> NumberPropertySpec.NumberFormat.NEW_TAIWAN_DOLLAR
        "danish_krone" -> NumberPropertySpec.NumberFormat.DANISH_KRONE
        "zloty" -> NumberPropertySpec.NumberFormat.ZLOTY
        "baht" -> NumberPropertySpec.NumberFormat.BAHT
        "forint" -> NumberPropertySpec.NumberFormat.FORINT
        "koruna" -> NumberPropertySpec.NumberFormat.KORUNA
        "shekel" -> NumberPropertySpec.NumberFormat.SHEKEL
        "chilean_peso" -> NumberPropertySpec.NumberFormat.CHILEAN_PESO
        "philippine_peso" -> NumberPropertySpec.NumberFormat.PHILIPPINE_PESO
        "dirham" -> NumberPropertySpec.NumberFormat.DIRHAM
        "colombian_peso" -> NumberPropertySpec.NumberFormat.COLOMBIAN_PESO
        "riyal" -> NumberPropertySpec.NumberFormat.RIYAL
        "ringgit" -> NumberPropertySpec.NumberFormat.RINGGIT
        "leu" -> NumberPropertySpec.NumberFormat.LEU

        else -> NumberPropertySpec.NumberFormat.UNKNOWN
    }
}