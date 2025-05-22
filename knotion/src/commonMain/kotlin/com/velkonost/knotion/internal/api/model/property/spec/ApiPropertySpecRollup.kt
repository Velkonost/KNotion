package com.velkonost.knotion.internal.api.model.property.spec

import com.velkonost.knotion.model.property.spec.RollupPropertySpec
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiPropertySpecRollup(
    @SerialName("relation_property_name")
    val relationPropertyName: String,
    @SerialName("relation_property_id")
    val relationPropertyId: String,
    @SerialName("rollup_property_name")
    val rollupPropertyName: String,
    @SerialName("rollup_property_id")
    val rollupPropertyId: String,
    val function: String,
)

internal fun String.toFunctionModel(): RollupPropertySpec.RollupFunction {
    return when (this) {
        "count_all" -> RollupPropertySpec.RollupFunction.COUNT_ALL
        "count_values" -> RollupPropertySpec.RollupFunction.COUNT_VALUES
        "count_unique_values" -> RollupPropertySpec.RollupFunction.COUNT_UNIQUE_VALUES
        "count_empty" -> RollupPropertySpec.RollupFunction.COUNT_EMPTY
        "count_not_empty" -> RollupPropertySpec.RollupFunction.COUNT_NOT_EMPTY
        "percent_empty" -> RollupPropertySpec.RollupFunction.PERCENT_EMPTY
        "percent_not_empty" -> RollupPropertySpec.RollupFunction.PERCENT_NOT_EMPTY
        "sum" -> RollupPropertySpec.RollupFunction.SUM
        "average" -> RollupPropertySpec.RollupFunction.AVERAGE
        "median" -> RollupPropertySpec.RollupFunction.MEDIAN
        "min" -> RollupPropertySpec.RollupFunction.MIN
        "max" -> RollupPropertySpec.RollupFunction.MAX
        "range" -> RollupPropertySpec.RollupFunction.RANGE
        else -> RollupPropertySpec.RollupFunction.UNKNOWN
    }
}