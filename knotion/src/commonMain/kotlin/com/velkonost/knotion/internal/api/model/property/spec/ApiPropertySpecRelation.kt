package com.velkonost.knotion.internal.api.model.property.spec

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiPropertySpecRelation(
    @SerialName("database_id")
    val databaseId: String,
    @SerialName("synced_property_name")
    val syncedPropertyName: String,
    @SerialName("synced_property_id")
    val syncedPropertyId: String,
)
