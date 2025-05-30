package com.velkonost.knotion.model

import com.velkonost.knotion.extension.UuidString

/**
 * Represents a reference to another Notion object (database, page, workspace, or unknown type).
 *
 * This sealed interface and its implementations are used to model parent/child relationships
 * and links between Notion objects in a type-safe way.
 */
sealed interface Reference

/**
 * Reference to a Notion database by its unique identifier.
 * @property id The UUID of the database.
 */
data class DatabaseReference(val id: UuidString) : Reference

/**
 * Reference to a Notion page by its unique identifier.
 * @property id The UUID of the page.
 */
data class PageReference(val id: UuidString) : Reference

/**
 * Reference to the entire Notion workspace (used for some API operations).
 */
data object WorkspaceReference : Reference

/**
 * This type is returned when a reference of a type unknown to this library is returned by the Notion API.
 * @property type The raw type string returned by the API.
 */
data class UnknownTypeReference(val type: String) : Reference
