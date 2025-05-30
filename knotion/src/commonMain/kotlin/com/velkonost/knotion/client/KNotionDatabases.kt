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

/**
 * Interface for managing Notion databases through the Notion API.
 * This interface provides methods to create, retrieve, update, and query databases in your Notion workspace.
 * Databases can be created as children of pages and can contain various property types and content.
 * 
 * Example usage:
 * ```
 * // Retrieve a database
 * val database = client.databases.getDatabase("database-id")
 * 
 * // Query a database
 * val results = client.databases.queryDatabase(
 *     id = "database-id",
 *     query = DatabaseQuery().apply {
 *         filter("Status", "equals", "Done")
 *     }
 * )
 * ```
 */
interface KNotionDatabases {
    /**
     * Retrieves a database by its ID.
     * This method fetches all database properties, schema, and metadata.
     * 
     * @param id The unique identifier of the database (UUID format)
     * @return A [Database] object containing all database data
     * @throws NotionApiException if the database doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/get-database">Retrieve a database</a>
     */
    suspend fun getDatabase(id: UuidString): Database

    /**
     * Lists all databases that have been shared with your integration.
     * This method returns a paginated list of databases that your integration has access to.
     * 
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [Database] objects and pagination information
     * @throws NotionApiException if the API request fails
     * @see <a href="https://developers.notion.com/reference/get-databases">List Databases</a>
     */
    suspend fun getDatabaseList(pagination: Pagination = Pagination()): ResultPage<Database>

    /**
     * Queries a database for pages that match specific criteria.
     * This method allows you to filter, sort, and paginate through database contents.
     * 
     * @param id The unique identifier of the database to query
     * @param query Optional query parameters to filter the results
     * @param sort Optional sorting parameters to order the results
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [Page] objects and pagination information
     * @throws NotionApiException if the database doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/post-database-query">Query a database</a>
     */
    suspend fun queryDatabase(
        id: UuidString,
        query: DatabaseQuery? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Page>

    /**
     * Creates a new database as a child of a page.
     * The database must have at least one title property defined in the properties list.
     * 
     * @param parentPageId The unique identifier of the parent page
     * @param title The title of the database as a rich text list
     * @param icon Optional emoji or file to use as the database icon
     * @param cover Optional file to use as the database cover
     * @param properties List of property specifications that define the database schema
     * @return The created [Database] object
     * @throws NotionApiException if the parent page doesn't exist, the properties are invalid,
     *         or the API request fails
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
     * Updates an existing database's properties.
     * This method allows you to modify the database's title, icon, cover, and property schema.
     * 
     * @param id The unique identifier of the database to update
     * @param title Optional new title for the database (null to keep current)
     * @param icon Optional new emoji or file to use as the database icon
     * @param cover Optional new file to use as the database cover
     * @param properties Optional new property specifications to update the database schema
     * @return The updated [Database] object
     * @throws NotionApiException if the database doesn't exist, the properties are invalid,
     *         or the API request fails
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