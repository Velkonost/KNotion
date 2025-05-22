package com.velkonost.knotion.client

import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.property.sort.PropertySort

interface KNotionSearch {
    /**
     * Search pages.
     *
     * The [query] is optional, when `null` this will return all pages.
     * @see <a href="https://developers.notion.com/reference/post-search">Search</a>
     */
    suspend fun searchPages(
        query: String? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Page>

    /**
     * Search databases.
     *
     * The [query] is optional, when `null` this will return all databases.
     * @see <a href="https://developers.notion.com/reference/post-search">Search</a>
     */
    suspend fun searchDatabases(
        query: String? = null,
        sort: PropertySort? = null,
        pagination: Pagination = Pagination(),
    ): ResultPage<Database>
}