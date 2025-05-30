package com.velkonost.knotion.extension

/**
 * Type alias for representing UUIDs as strings.
 * Used throughout the codebase to indicate that a string value is expected to be a UUID.
 */
typealias UuidString = String

/**
 * Type alias for representing URLs as strings.
 * Used throughout the codebase to indicate that a string value is expected to be a URL.
 */
typealias UrlString = String

/**
 * Extension function for [UuidString] that returns the UUID in hyphenated format.
 *
 * If the string already contains hyphens, it is returned as-is. Otherwise, hyphens are inserted
 * at the standard UUID positions (8, 13, 18, 23) to convert a plain 32-character string into
 * the canonical UUID format (8-4-4-4-12).
 *
 * Example:
 * ```
 * val raw = "123e4567e89b12d3a456426655440000"
 * val hyphened = raw.hyphened() // "123e4567-e89b-12d3-a456-426655440000"
 * ```
 */
fun UuidString.hyphened() = if (contains('-')) {
    this
} else {
    StringBuilder(this)
        .insert(8, '-')
        .insert(13, '-')
        .insert(18, '-')
        .insert(23, '-')
        .toString()
}
