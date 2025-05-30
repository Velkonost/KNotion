package com.velkonost.knotion.internal.api.model.page.request

import com.velkonost.knotion.extension.hyphened
import com.velkonost.knotion.internal.api.model.ApiReference
import com.velkonost.knotion.internal.api.model.page.toApi
import com.velkonost.knotion.model.Color
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.property.value.*
import com.velkonost.knotion.model.richText.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

/**
 * See [Reference](https://developers.notion.com/reference/post-page).
 */
@Serializable
internal data class CreatePageRequest(
    val parent: ApiReference,
    val properties: Map<String, JsonElement>,
    val children: List<Block>? = null,
    val icon: EmojiOrFile? = null,
    val cover: File? = null,
)

@Serializable
internal data class PropertyStringValue(
    val id: String,
    val name: String,
    val value: String
)

internal fun PropertyValue<*>.toStringValue() = PropertyStringValue(id, name, value.toString())

internal fun PropertyValue<*>.toApi(): Pair<String, JsonElement> {
    return this.name to when (this) {
        is NumberPropertyValue -> buildJsonObject {
            put("number", this@toApi.value)
        }

        is RichTextPropertyValue -> buildJsonObject {
            put("rich_text", this@toApi.value.toApi())
        }

        is TitlePropertyValue -> buildJsonObject {
            put("title", this@toApi.value.toApi())
        }

        is SelectPropertyValue -> buildJsonObject {
            put(
                "select",
                this@toApi.value?.let {
                    buildJsonObject {
                        if (it.name.isNotEmpty()) {
                            put("name", it.name)
                        } else {
                            put("id", it.id)
                        }
                    }
                } ?: JsonNull
            )
        }

        is MultiSelectPropertyValue -> buildJsonObject {
            put(
                "multi_select",
                this@toApi.value.let {
                    buildJsonArray {
                        for (option in it)
                            addJsonObject {
                                if (option.name.isNotEmpty()) {
                                    put("name", option.name)
                                } else {
                                    put("id", option.id)
                                }
                            }
                    }
                }
            )
        }

        is DatePropertyValue -> buildJsonObject {
            put(
                "date",
                this@toApi.value?.let {
                    buildJsonObject {
                        put("start", it.start.toApi())
                        it.end?.let { put("end", it.toApi()) }
                    }
                } ?: JsonNull
            )
        }

        is RelationPropertyValue -> buildJsonObject {
            put(
                "relation",
                this@toApi.value.let {
                    buildJsonArray {
                        for (id in it)
                            addJsonObject {
                                put("id", id.hyphened())
                            }
                    }
                }
            )
        }

        is PeoplePropertyValue -> buildJsonObject {
            put(
                "people",
                this@toApi.value.let {
                    buildJsonArray {
                        for (user in it)
                            addJsonObject {
                                put("id", user.id.hyphened())
                            }
                    }
                }
            )
        }

        is CheckboxPropertyValue -> buildJsonObject {
            put("checkbox", this@toApi.value)
        }

        is UrlPropertyValue -> buildJsonObject {
            put("url", this@toApi.value)
        }

        is PhoneNumberPropertyValue -> buildJsonObject {
            put("phone_number", this@toApi.value)
        }

        is EmailPropertyValue -> buildJsonObject {
            put("email", this@toApi.value)
        }

        // These are all read only
        is FormulaPropertyValue,
        is CreatedByPropertyValue,
        is RollupPropertyValue,
        is LastEditedTimePropertyValue,
        is CreatedTimePropertyValue,
        is LastEditedByPropertyValue,
        is FilesPropertyValue,
        is UnknownTypePropertyValue,
            -> throw IllegalStateException()
    }
}

private fun RichTextList.toApi() = buildJsonArray {
    for (richText in this@toApi.items) {
        addJsonObject {
            if (richText.annotations != RichTextAnnotations.DEFAULT) {
                putJsonObject("annotations") {
                    if (richText.annotations.bold) put("bold", true)
                    if (richText.annotations.italic) put("italic", true)
                    if (richText.annotations.strikethrough) put("strikethrough", true)
                    if (richText.annotations.underline) put("underline", true)
                    if (richText.annotations.code) put("code", true)
                    if (richText.annotations.color != Color.DEFAULT) {
                        put("color", richText.annotations.color.toApi())
                    }
                }
            }

            @Suppress("UNUSED_VARIABLE")
            val ignored = when (richText) {
                is RichTextBase -> putJsonObject("text") {
                    put("content", richText.plainText)
                    if (richText.linkUrl != null) putJsonObject("link") {
                        put("url", richText.linkUrl)
                    }
                }

                is UserMentionRichText -> putJsonObject("mention") {
                    putJsonObject("user") {
                        put("id", richText.user.id.hyphened())
                    }
                }

                is PageMentionRichText -> putJsonObject("mention") {
                    putJsonObject("page") {
                        put("id", richText.pageId.hyphened())
                    }
                }

                is DatabaseMentionRichText -> putJsonObject("mention") {
                    putJsonObject("database") {
                        put("id", richText.databaseId.hyphened())
                    }
                }

                is DateMentionRichText -> putJsonObject("mention") {
                    putJsonObject("date") {
                        put("start", richText.dateOrDateRange.start.toApi())
                        richText.dateOrDateRange.end?.let {
                            put("end", it.toApi())
                        }
                    }
                }

                is RichTextEquation -> putJsonObject("equation") {
                    put("expression", richText.expression)
                }

                is UnknownTypeMentionRichText,
                is RichTextUnknownType,
                    -> throw IllegalStateException()
            }
        }
    }
}

private fun Color.toApi() = when (this) {
    Color.UNKNOWN, Color.DEFAULT -> "default"
    Color.GRAY -> "gray"
    Color.BROWN -> "brown"
    Color.ORANGE -> "orange"
    Color.YELLOW -> "yellow"
    Color.GREEN -> "green"
    Color.BLUE -> "blue"
    Color.PURPLE -> "purple"
    Color.PINK -> "pink"
    Color.RED -> "red"
    Color.GRAY_BACKGROUND -> "gray_background"
    Color.BROWN_BACKGROUND -> "brown_background"
    Color.ORANGE_BACKGROUND -> "orange_background"
    Color.YELLOW_BACKGROUND -> "yellow_background"
    Color.GREEN_BACKGROUND -> "green_background"
    Color.BLUE_BACKGROUND -> "blue_background"
    Color.PURPLE_BACKGROUND -> "purple_background"
    Color.PINK_BACKGROUND -> "pink_background"
    Color.RED_BACKGROUND -> "red_background"
}
