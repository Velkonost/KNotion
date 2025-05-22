package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.TitlePropertyValue
import com.velkonost.knotion.model.richText.RichTextList

internal data class TitlePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: RichTextList,
) : TitlePropertyValue

