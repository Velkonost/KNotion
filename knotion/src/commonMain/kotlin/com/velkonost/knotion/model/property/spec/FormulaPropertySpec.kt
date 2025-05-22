package com.velkonost.knotion.model.property.spec

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface FormulaPropertySpec : PropertySpec {
    /**
     * Formula to evaluate for this property.
     * You can read more about the
     * [syntax for formulas](https://notion.so/notion/Formulas-28f3f5c3ae644c59b4d862046ea6a541) in the help center.
     */
    val expression: String
}
