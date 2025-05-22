package com.velkonost.knotion.internal.model.richText.mention

import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.richText.DateMentionRichText
import com.velkonost.knotion.model.richText.RichTextAnnotations

internal data class RichTextDateMentionImpl(
    override val plainText: String,
    override val href: String?,
    override val annotations: RichTextAnnotations,
    override val dateOrDateRange: DateOrDateRange,
) : DateMentionRichText
