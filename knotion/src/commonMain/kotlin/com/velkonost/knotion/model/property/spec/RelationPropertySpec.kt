package com.velkonost.knotion.model.property.spec

import com.velkonost.knotion.extension.UuidString

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface RelationPropertySpec : PropertySpec {
    /**
     * The database this relation refers to.
     * New linked pages must belong to this database in order to be valid.
     */
    val databaseId: UuidString

    /**
     * By default, relations are formed as two synced properties across databases: if you make a change to one property,
     * it updates the synced property at the same time.
     * [syncedPropertyName] refers to the name of the property in the related database.
     */
    val syncedPropertyName: String

    /**
     * By default, relations are formed as two synced properties across databases: if you make a change to one property,
     * it updates the synced property at the same time.
     * [syncedPropertyId] refers to the id of the property in the related database.
     * Like [PropertySpec.id], this is usually a short string of random letters and symbols.
     */
    val syncedPropertyId: String
}
