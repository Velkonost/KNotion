package com.velkonost.knotion.model.richText

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.user.User

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
sealed interface MentionRichText : RichText

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface DatabaseMentionRichText : MentionRichText {
    val databaseId: UuidString
}

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface DateMentionRichText : MentionRichText {
    val dateOrDateRange: DateOrDateRange
}

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface PageMentionRichText : MentionRichText {
    val pageId: UuidString
}

/**
 * This type is returned when a Mention Rich Text of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface UnknownTypeMentionRichText : MentionRichText {
    val type: String
}

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface UserMentionRichText : MentionRichText {
    val user: User
}
