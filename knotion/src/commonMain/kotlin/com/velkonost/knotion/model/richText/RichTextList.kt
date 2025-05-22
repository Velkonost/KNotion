package com.velkonost.knotion.model.richText

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.model.richText.RichTextBaseImpl
import com.velkonost.knotion.internal.model.richText.RichTextEquationImpl
import com.velkonost.knotion.internal.model.richText.mention.RichTextDatabaseMentionImpl
import com.velkonost.knotion.internal.model.richText.mention.RichTextDateMentionImpl
import com.velkonost.knotion.internal.model.richText.mention.RichTextPageMentionImpl
import com.velkonost.knotion.internal.model.richText.mention.RichTextUserMentionImpl
import com.velkonost.knotion.internal.model.user.PersonImpl
import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.date.DateOrDateTime
import kotlinx.serialization.Serializable

@Serializable
class RichTextList {
    val items: MutableList<RichText> = mutableListOf()

    val plainText: String
        get() = items.joinToString(separator = "") { it.plainText }

    private fun add(richText: RichText): RichTextList = apply {
        items.add(richText)
    }

    fun text(
        text: String,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = text(text = text, linkUrl = null, annotations = annotations)

    fun text(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextBaseImpl(
            plainText = text,
            href = null,
            annotations = annotations,
            linkUrl = linkUrl,
        )
    )

    fun userMention(
        userId: UuidString,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextUserMentionImpl(
            plainText = "",
            href = null,
            annotations = annotations,
            user = PersonImpl(userId, "", null, "")
        )
    )

    fun pageMention(
        pageId: UuidString,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextPageMentionImpl(
            plainText = "",
            href = null,
            annotations = annotations,
            pageId = pageId
        )
    )

    fun databaseMention(
        databaseId: UuidString,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextDatabaseMentionImpl(
            plainText = "",
            href = null,
            annotations = annotations,
            databaseId = databaseId
        )
    )

    fun dateMention(
        start: DateOrDateTime,
        end: DateOrDateTime? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextDateMentionImpl(
            plainText = "",
            href = null,
            annotations = annotations,
            dateOrDateRange = DateOrDateRange(start, end)
        )
    )

    fun equation(
        expression: String,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(
        RichTextEquationImpl(
            plainText = "",
            href = null,
            annotations = annotations,
            expression = expression
        )
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as RichTextList

        return items == other.items
    }

    override fun hashCode(): Int {
        return items.hashCode()
    }
}

fun text(text: String) = RichTextList().text(text)
