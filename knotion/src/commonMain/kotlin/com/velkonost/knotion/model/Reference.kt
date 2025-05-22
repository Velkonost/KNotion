package com.velkonost.knotion.model

import com.velkonost.knotion.extension.UuidString

/**
 * A reference to another object.
 */
sealed interface Reference

data class DatabaseReference(val id: UuidString) : Reference

data class PageReference(val id: UuidString) : Reference

data object WorkspaceReference : Reference

/**
 * This type is returned when a reference of a type unknown to this library is returned by the Notion API.
 */
data class UnknownTypeReference(val type: String) : Reference
