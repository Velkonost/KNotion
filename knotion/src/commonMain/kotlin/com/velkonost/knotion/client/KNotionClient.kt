package com.velkonost.knotion.client

interface KNotionClient {

    /**
     * User related APIs.
     */
    val users: KNotionUsers

    /**
     * Database related APIs.
     */
    val databases: KNotionDatabases

    /**
     * Page related APIs.
     */
    val pages: KNotionPages

    /**
     * Block related APIs.
     */
    val blocks: KNotionBlocks

    /**
     * Search related APIs.
     */
    val search: KNotionSearch
}