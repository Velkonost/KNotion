package com.velkonost.knotion.model.property.spec

/**
 * Represents a number property specification in a Notion database.
 * This property allows users to store numerical values with various formatting options,
 * such as currency, percentage, or scientific notation.
 * 
 * Number properties can be used for:
 * - Basic arithmetic calculations
 * - Statistical analysis
 * - Financial tracking
 * - Scientific measurements
 * 
 * The numbers can be formatted in different ways using the [format] property,
 * and they can be used for filtering, sorting, and calculations in database views.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#number">Number property</a>
 */
interface NumberPropertySpec : PropertySpec {
    /**
     * How the number is displayed in Notion.
     */
    val format: NumberFormat

    enum class NumberFormat {
        /**
         * This type is returned when a type unknown to this library is returned by the Notion API.
         */
        UNKNOWN,

        NUMBER,
        NUMBER_WITH_COMMAS,
        PERCENT,
        DOLLAR,
        EURO,
        POUND,
        YEN,
        RUBLE,
        RUPEE,
        WON,
        YUAN,
        CANADIAN_DOLLAR,
        REAL,
        LIRA,
        RUPIAH,
        FRANC,
        HONG_KONG_DOLLAR,
        NEW_ZEALAND_DOLLAR,
        KRONA,
        NORWEGIAN_KRONE,
        MEXICAN_PESO,
        RAND,
        NEW_TAIWAN_DOLLAR,
        DANISH_KRONE,
        ZLOTY,
        BAHT,
        FORINT,
        KORUNA,
        SHEKEL,
        CHILEAN_PESO,
        PHILIPPINE_PESO,
        DIRHAM,
        COLOMBIAN_PESO,
        RIYAL,
        RINGGIT,
        LEU
    }
}
