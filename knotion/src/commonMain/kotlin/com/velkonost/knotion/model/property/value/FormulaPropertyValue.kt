
package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.model.date.DateOrDateRange

/**
 * Note: unlike [PropertyValue], the value of a [FormulaPropertyValue] *can* be `null`, because
 * a formula can for instance reference another property, which is unset.
 *
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
sealed interface FormulaPropertyValue<T> : PropertyValue<T>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface BooleanFormulaPropertyValue : FormulaPropertyValue<Boolean>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface DateFormulaPropertyValue : FormulaPropertyValue<DateOrDateRange?>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface NumberFormulaPropertyValue : FormulaPropertyValue<Number?>

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface StringFormulaPropertyValue : FormulaPropertyValue<String?>

/**
 * This type is returned when a Formula Property Value of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface UnknownTypeFormulaPropertyValue : FormulaPropertyValue<Nothing?> {
    val type: String
}
