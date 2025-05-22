package com.velkonost.knotion.model.property.spec

/**
 * A rollup uses a relation property that exists on the current database and extracts a property of
 * the related pages as an input to a chosen function.
 *
 * See [Reference](https://developers.notion.com/reference/database).
 */
interface RollupPropertySpec : PropertySpec {
    /**
     * The name of the relation property this property is responsible for rolling up.
     */
    val relationPropertyName: String

    /**
     * The ID of the relation property this property is responsible for rolling up.
     */
    val relationPropertyId: String

    /**
     * The name of the property of the pages in the related database that is used as an input to [function].
     */
    val rollupPropertyName: String

    /**
     * The ID of the property of the pages in the related database that is used as an input to [function].
     */
    val rollupPropertyId: String

    /**
     * The function that is evaluated for every page in the relation of the rollup.
     */
    val function: RollupFunction

    enum class RollupFunction {
        /**
         * This type is returned when a type unknown to this library is returned by the Notion API.
         */
        UNKNOWN,

        COUNT_ALL,
        COUNT_VALUES,
        COUNT_UNIQUE_VALUES,
        COUNT_EMPTY,
        COUNT_NOT_EMPTY,
        PERCENT_EMPTY,
        PERCENT_NOT_EMPTY,
        SUM,
        AVERAGE,
        MEDIAN,
        MIN,
        MAX,
        RANGE,
    }
}
