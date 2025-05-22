package com.velkonost.knotion.internal.api.model.page.block

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
@Serializable
internal data class ApiBlock(
    val id: String,
    @SerialName("created_time")
    val createdTime: String,
    @SerialName("last_edited_time")
    val lastEditedTime: String,
    @SerialName("has_children")
    val hasChildren: Boolean,
    val type: String,
    val paragraph: ApiBlockText? = null,
    @SerialName("heading_1")
    val heading1: ApiBlockText? = null,
    @SerialName("heading_2")
    val heading2: ApiBlockText? = null,
    @SerialName("heading_3")
    val heading3: ApiBlockText? = null,
    @SerialName("bulleted_list_item")
    val bulletedListItem: ApiBlockText? = null,
    @SerialName("numbered_list_item")
    val numberedListItem: ApiBlockText? = null,
    val toggle: ApiBlockText? = null,
    @SerialName("to_do")
    val toDo: ApiBlockTodo? = null,
    @SerialName("child_page")
    val childPage: ApiBlockChildPage? = null,
    @SerialName("child_database")
    val childDatabase: ApiBlockChildDatabase? = null,
    val code: ApiBlockCode? = null,
    val equation: ApiBlockEquation? = null,
    val callout: ApiBlockCallout? = null,
    val embed: ApiBlockEmbed? = null,
    val quote: ApiBlockText? = null,
    val bookmark: ApiBlockBookmark? = null,
    val image: ApiBlockImage? = null,
    val video: ApiBlockVideo? = null,
    @SerialName("synced_block")
    val syncedBlock: ApiSyncedBlock? = null,
)
