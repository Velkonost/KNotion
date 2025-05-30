package com.velkonost.knotion.client

import com.velkonost.knotion.internal.client.KNotionClientImpl

/**
 * Entry point for creating and configuring a Notion API client.
 * This object provides factory methods to create instances of [KNotionClient]
 * with the necessary configuration.
 * 
 * Example usage:
 * ```
 * val client = KNotion.setupClient("your-notion-api-token")
 * ```
 */
object KNotion {
    /**
     * Creates a new Notion API client instance with the provided access token.
     * 
     * @param accessToken The Notion API integration token (starts with "secret_")
     * @return A configured [KNotionClient] instance ready to use
     * @throws IllegalArgumentException if the access token is invalid or empty
     */
    fun setupClient(accessToken: String): KNotionClient {
        return KNotionClientImpl(accessToken)
    }
}