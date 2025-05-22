package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Color
import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.richText.RichTextAnnotations
import com.velkonost.knotion.model.richText.RichTextList
import com.velkonost.knotion.internal.model.property.SelectOptionImpl
import com.velkonost.knotion.internal.model.property.value.CheckboxPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.DatePropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.EmailPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.MultiSelectPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.NumberPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.PeoplePropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.PhoneNumberPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.RelationPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.RichTextPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.SelectPropertyValueImpl
import com.velkonost.knotion.internal.model.property.value.TitlePropertyValueImpl
import org.jraf.klibnotion.internal.model.property.value.UrlPropertyValueImpl
import com.velkonost.knotion.internal.model.user.PersonImpl
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmOverloads

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
sealed interface PropertyValue<T> {
    val id: String
    val name: String
    val value: T
}

class PropertyValueList {
    private val propertyValueList = mutableListOf<PropertyValue<*>>()

    fun getAll(): List<PropertyValue<*>> = propertyValueList.toList()

    private fun add(propertyValue: PropertyValue<*>): PropertyValueList = apply {
        propertyValueList.add(propertyValue)
    }

    fun number(idOrName: String, number: Number?): PropertyValueList = add(
        NumberPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = number
        )
    )

    @JvmOverloads
    fun text(
        idOrName: String,
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): PropertyValueList = text(idOrName = idOrName, richTextList = RichTextList().text(text, linkUrl, annotations))

    fun text(idOrName: String, richTextList: RichTextList?): PropertyValueList = add(
        RichTextPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = richTextList ?: RichTextList(),
        )
    )

    @JvmOverloads
    fun title(
        idOrName: String,
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): PropertyValueList = title(idOrName = idOrName, richTextList = RichTextList().text(text, linkUrl, annotations))

    fun title(idOrName: String, richTextList: RichTextList?): PropertyValueList = add(
        TitlePropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = richTextList ?: RichTextList(),
        )
    )

    fun selectByName(idOrName: String, selectName: String?): PropertyValueList = add(
        SelectPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = selectName?.let { SelectOptionImpl(id = "", name = it, color = Color.DEFAULT) }
        )
    )

    // TODO Actually not supported by the Notion API for now. Keeping it commented out for now because it may be supported
    // in a future version.
    //        fun selectById(idOrName: String, selectId: UuidString): PropertyValueList = add(SelectPropertyValueImpl(
    //            id = idOrName,
    //            name = idOrName,
    //            value = SelectOptionImpl(id = selectId, name = "", color = Color.DEFAULT)
    //        ))

    fun multiSelectByNames(idOrName: String, vararg selectNames: String): PropertyValueList =
        add(MultiSelectPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = selectNames.map { selectName ->
                SelectOptionImpl(
                    id = "",
                    name = selectName,
                    color = Color.DEFAULT
                )
            }
        ))

    fun date(idOrName: String, date: DateOrDateRange?): PropertyValueList = add(
        DatePropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = date,
        )
    )

    fun relation(idOrName: String, vararg pageIds: UuidString): PropertyValueList = add(
        RelationPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = pageIds.asList(),
        )
    )

    fun people(idOrName: String, vararg peopleIds: UuidString): PropertyValueList = add(
        PeoplePropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = peopleIds.map { PersonImpl(it, "", null, "") },
        )
    )

    fun checkbox(idOrName: String, checked: Boolean): PropertyValueList = add(
        CheckboxPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = checked,
        )
    )

    fun url(idOrName: String, url: String?): PropertyValueList = add(
        UrlPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = url,
        )
    )

    fun email(idOrName: String, email: String?): PropertyValueList = add(
        EmailPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = email,
        )
    )

    fun phoneNumber(idOrName: String, phoneNumber: String?): PropertyValueList = add(
        PhoneNumberPropertyValueImpl(
            id = idOrName,
            name = idOrName,
            value = phoneNumber,
        )
    )
}
