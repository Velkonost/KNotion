package com.velkonost.knotion.model.property.spec

import com.velkonost.knotion.internal.model.property.spec.*
import com.velkonost.knotion.model.property.SelectOptionList
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
sealed interface PropertySpec {
    /**
     * The name of the property as it appears in Notion.
     */
    val name: String

    /**
     * The ID of the property, usually a short string of random letters and symbols.
     * Some automatically generated property types have special human-readable IDs.
     * For example, all Title properties have an ID of `title`.
     */
    val id: String
}

@Serializable
class PropertySpecList {
    private val propertySpecList = mutableListOf<PropertySpec>()

    private fun add(propertySpec: PropertySpec): PropertySpecList = apply {
        propertySpecList.add(propertySpec)
    }

    fun number(name: String, format: NumberPropertySpec.NumberFormat): PropertySpecList = add(
        NumberPropertySpecImpl(
            id = name,
            name = name,
            format = format,
        )
    )

    fun text(name: String): PropertySpecList = add(
        RichTextPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun title(name: String): PropertySpecList = add(
        TitlePropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun select(name: String, options: SelectOptionList): PropertySpecList = add(
        SelectPropertySpecImpl(
            id = name,
            name = name,
            options = options.selectOptionList,
        )
    )

    fun multiSelect(name: String, options: SelectOptionList): PropertySpecList = add(
        MultiSelectPropertySpecImpl(
            id = name,
            name = name,
            options = options.selectOptionList,
        )
    )

    fun date(name: String): PropertySpecList = add(
        DatePropertySpecImpl(
            id = name,
            name = name,
        )
    )

    // TODO Commented for now because for some reason this is not supported by the API at the moment
//    fun relation(
//        name: String,
//        databaseId: UuidString,
//        syncedPropertyName: String,
//        syncedPropertyId: String,
//    ): PropertySpecList = add(
//        RelationPropertySpecImpl(
//            id = name,
//            name = name,
//            databaseId = databaseId,
//            syncedPropertyName = syncedPropertyName,
//            syncedPropertyId = syncedPropertyId,
//        )
//    )

    fun people(name: String): PropertySpecList = add(
        PeoplePropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun checkbox(name: String): PropertySpecList = add(
        CheckboxPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun url(name: String): PropertySpecList = add(
        UrlPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun email(name: String): PropertySpecList = add(
        EmailPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun phoneNumber(name: String): PropertySpecList = add(
        PhoneNumberPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun file(name: String): PropertySpecList = add(
        FilesPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun formula(name: String, expression: String): PropertySpecList = add(
        FormulaPropertySpecImpl(
            id = name,
            name = name,
            expression = expression,
        )
    )

    fun createdTime(name: String): PropertySpecList = add(
        CreatedTimePropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun createdBy(name: String): PropertySpecList = add(
        CreatedByPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun lastEditedTime(name: String): PropertySpecList = add(
        LastEditedTimePropertySpecImpl(
            id = name,
            name = name,
        )
    )

    fun lastEditedBy(name: String): PropertySpecList = add(
        LastEditedByPropertySpecImpl(
            id = name,
            name = name,
        )
    )

    // TODO Commented for now because for some reason this is not supported by the API at the moment
//    fun rollup(
//        name: String,
//        relationPropertyName: String,
//        relationPropertyId: String,
//        rollupPropertyName: String,
//        rollupPropertyId: String,
//        function: RollupPropertySpec.RollupFunction,
//    ): PropertySpecList = add(
//        RollupPropertySpecImpl(
//            id = name,
//            name = name,
//            relationPropertyName = relationPropertyName,
//            relationPropertyId = relationPropertyId,
//            rollupPropertyName = rollupPropertyName,
//            rollupPropertyId = rollupPropertyId,
//            function = function,
//        )
//    )
}
