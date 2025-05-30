package com.velkonost.knotion.client

/**
 * Main interface for interacting with the Notion API.
 * This client provides access to all Notion API endpoints through specialized interfaces
 * for different resource types (users, databases, pages, blocks, and search).
 * 
 * To use this client, you need to initialize it with a valid Notion API token.
 * Example usage:
 * ```
 * val client = KNotion.createClient("your-notion-api-token")
 * val myPage = client.pages.retrieve("page-id")
 * ```
 */
interface KNotionClient {

    /**
     * Provides access to user-related API endpoints.
     * This interface allows you to retrieve information about users in your Notion workspace,
     * including the current user and workspace members.
     */
    val users: KNotionUsers

    /**
     * Provides access to database-related API endpoints.
     * This interface allows you to create, retrieve, update, and query Notion databases,
     * as well as manage their properties and content.
     */
    val databases: KNotionDatabases

    /**
     * Provides access to page-related API endpoints.
     * This interface allows you to create, retrieve, update, and delete Notion pages,
     * including managing page properties and content.
     */
    val pages: KNotionPages

    /**
     * Provides access to block-related API endpoints.
     * This interface allows you to create, retrieve, update, and delete blocks within pages,
     * including text blocks, lists, to-do items, and other content types.
     */
    val blocks: KNotionBlocks

    /**
     * Provides access to search-related API endpoints.
     * This interface allows you to search across all pages and databases in your Notion workspace,
     * with support for filtering and sorting results.
     */
    val search: KNotionSearch
}