package com.velkonost.knotion.client

import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.property.sort.PropertySort

/**
 * Interface for searching Notion content through the Notion API.
 * This interface provides methods to search for pages and databases across your Notion workspace.
 * Search results can be filtered, sorted, and paginated.
 * 
 * Example usage:
 * ```
 * // Search for pages containing "meeting notes"
 * val pages = client.search.searchPages(
 *     query = "meeting notes",
 *     sort = PropertySort().apply {
 *         timestamp("last_edited_time", "descending")
 *     }
 * )
 * 
 * // List all databases
 * val databases = client.search.searchDatabases()
 * ```
 */
interface KNotionSearch {
    /**
     * Searches for pages across your Notion workspace.
     * This method allows you to find pages by their content, title, or other properties.
     * 
     * The search is performed across all pages that your integration has access to.
     * When [query] is null, all accessible pages are returned.
     * 
     * @param query Optional search query to filter pages (null to return all pages)
     * @param sort Optional sorting parameters to order the results
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [Page] objects and pagination information
     * @throws NotionApiException if the API request fails
     * @see <a href="https://developers.notion.com/reference/post-search">Search</a>
     */
    suspend fun searchPages(
        query: String? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Page>

    /**
     * Searches for databases across your Notion workspace.
     * This method allows you to find databases by their title or other properties.
     * 
     * The search is performed across all databases that your integration has access to.
     * When [query] is null, all accessible databases are returned.
     * 
     * @param query Optional search query to filter databases (null to return all databases)
     * @param sort Optional sorting parameters to order the results
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [Database] objects and pagination information
     * @throws NotionApiException if the API request fails
     * @see <a href="https://developers.notion.com/reference/post-search">Search</a>
     */
    suspend fun searchDatabases(
        query: String? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Database>
}