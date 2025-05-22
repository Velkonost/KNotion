package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.model.date.DateOrDateRange

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
sealed interface RollupPropertyValue<T> : PropertyValue<T>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 *
 * Note: the [PropertyValue]s in the list will have empty string (`""`)
 * for the [PropertyValue.name] and [PropertyValue.id] fields.
 */
interface ArrayRollupPropertyValue : RollupPropertyValue<List<PropertyValue<*>>?>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface DateRollupPropertyValue : RollupPropertyValue<DateOrDateRange?>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface NumberRollupPropertyValue : RollupPropertyValue<Number?>

/**
 * This type is returned when a Rollup Property Value of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface UnknownTypeRollupPropertyValue : RollupPropertyValue<Nothing?> {
    val type: String
}
