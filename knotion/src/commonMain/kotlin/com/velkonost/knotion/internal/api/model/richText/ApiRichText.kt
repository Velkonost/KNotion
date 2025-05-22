package com.velkonost.knotion.internal.api.model.richText

import com.velkonost.knotion.internal.api.model.page.toModel
import com.velkonost.knotion.internal.api.model.user.toModel
import com.velkonost.knotion.internal.model.richText.RichTextBaseImpl
import com.velkonost.knotion.internal.model.richText.RichTextEquationImpl
import com.velkonost.knotion.internal.model.richText.RichTextUnknownTypeImpl
import com.velkonost.knotion.internal.model.richText.mention.*
import com.velkonost.knotion.model.richText.RichText
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiRichText(
    @SerialName("plain_text")
    val plainText: String,
    val href: String? = null,
    val annotations: ApiAnnotations,
    val type: String,
    val text: ApiRichTextText? = null,
    val mention: ApiRichTextMention? = null,
    val equation: ApiRichTextEquation? = null,
)

internal fun ApiRichText.toModel(): RichText {
    val plainText = this.plainText
    val href = this.href
    val annotations = this.annotations.toModel()
    return when (this.type) {
        "text" -> RichTextBaseImpl(
            plainText = plainText,
            href = href,
            annotations = annotations,
            linkUrl = this.text?.link?.url.orEmpty()
        )

        "mention" -> when (mention?.type) {
            "user" -> RichTextUserMentionImpl(
                plainText = plainText,
                href = href,
                annotations = annotations,
                user = this.mention.user!!.toModel()
            )
            "page" -> RichTextPageMentionImpl(
                plainText = plainText,
                href = href,
                annotations = annotations,
                pageId = this.mention.page!!.id
            )
            "database" -> RichTextDatabaseMentionImpl(
                plainText = plainText,
                href = href,
                annotations = annotations,
                databaseId = this.mention.database!!.id
            )
            "date" -> RichTextDateMentionImpl(
                plainText = plainText,
                href = href,
                annotations = annotations,
                dateOrDateRange = this.mention.date!!.toModel()
            )
            else -> RichTextUnknownTypeMentionImpl(
                plainText = plainText,
                href = href,
                annotations = annotations,
                type = this.mention?.type.orEmpty()
            )
        }

        "equation" -> RichTextEquationImpl(
            plainText = plainText,
            href = href,
            annotations = annotations,
            expression = this.equation?.expression.orEmpty()
        )

        else -> RichTextUnknownTypeImpl(
            plainText = plainText,
            href = href,
            annotations = annotations,
            type = this.type
        )
    }
}