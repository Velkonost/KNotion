package com.velkonost.knotion.internal.model.richText.mention

import com.velkonost.knotion.model.richText.RichTextAnnotations
import com.velkonost.knotion.model.richText.UnknownTypeMentionRichText

internal data class RichTextUnknownTypeMentionImpl(
    override val plainText: String,
    override val href: String?,
    override val annotations: RichTextAnnotations,
    override val type: String,
) : UnknownTypeMentionRichText
