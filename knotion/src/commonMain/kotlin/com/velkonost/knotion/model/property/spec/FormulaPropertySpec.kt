package com.velkonost.knotion.model.property.spec

/**
 * Represents a formula property specification in a Notion database.
 * Formula properties automatically compute values based on other properties in the database
 * using a formula expression.
 * 
 * Formulas can perform calculations, manipulate text, create conditional logic,
 * and more. The formula's result type is determined by the expression used.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#formula-property-values">Formula property values</a>
 */
interface FormulaPropertySpec : PropertySpec {
    /**
     * The formula expression that computes the property's value.
     * The expression uses Notion's formula syntax, which is similar to spreadsheet formulas.
     * 
     * Examples:
     * - `prop("Price") * prop("Quantity")` - Calculates total cost
     * - `if(prop("Status") == "Done", "Complete", "In Progress")` - Conditional logic
     * - `concat(prop("First Name"), " ", prop("Last Name"))` - Text manipulation
     * 
     * @see <a href="https://www.notion.so/notion/Formulas-28f3f5c3ae644c59b4d862046ea6a541">Formula syntax documentation</a>
     */
    val expression: String
}
