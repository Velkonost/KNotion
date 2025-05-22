package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.database.query.DatabaseQuery
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.property.sort.PropertySort
import com.velkonost.knotion.model.property.spec.PropertySpecList
import com.velkonost.knotion.model.richText.RichTextList

interface KNotionDatabases {
    /**
     * Retrieve a database.
     * @see <a href="https://developers.notion.com/reference/get-database">Retrieve a database</a>
     */
    suspend fun getDatabase(id: UuidString): Database

    /**
     * List Databases.
     * This lists all the databases that have been shared with your bot.
     * @see <a href="https://developers.notion.com/reference/get-databases">List Databases</a>
     */
    suspend fun getDatabaseList(pagination: Pagination = Pagination()): ResultPage<Database>

    /**
     * Query a database.
     * @see <a href="https://developers.notion.com/reference/post-database-query">Query a database</a>
     */
    suspend fun queryDatabase(
        id: UuidString,
        query: DatabaseQuery? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Page>

    /**
     * Create a database inside a page.
     *
     * Note: [properties] must contain exactly one title property.
     * @see <a href="https://developers.notion.com/reference/create-a-database">Create a database</a>
     */
    suspend fun createDatabase(
        parentPageId: UuidString,
        title: RichTextList = RichTextList(),
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertySpecList = PropertySpecList(),
    ): Database

    /**
     * Update a database.
     *
     * @param title The title to update, or `null` to keep the current title.
     * @param properties The properties to update, or `null` to keep the properties as is.
     *
     * @see <a href="https://developers.notion.com/reference/update-a-database">Update a database</a>
     */
    suspend fun updateDatabase(
        id: UuidString,
        title: RichTextList? = null,
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertySpecList? = null,
    ): Database
}