package com.velkonost.knotion.model.property.spec

/**
 * See [Reference](https://developers.notion.com/reference/database).
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
