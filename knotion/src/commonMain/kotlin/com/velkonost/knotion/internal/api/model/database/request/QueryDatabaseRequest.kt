package com.velkonost.knotion.internal.api.model.database.request

import com.velkonost.knotion.internal.api.model.database.query.*
import com.velkonost.knotion.internal.api.model.page.toApi
import com.velkonost.knotion.model.database.query.filter.DatabaseQueryPredicate
import com.velkonost.knotion.model.database.query.filter.DatabaseQueryPropertyFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class QueryDatabaseRequest(
    val filter: DatabaseQueryRequestFilters? = null,
    val sorts: List<ApiDatabaseQuerySort>? = null,
    @SerialName("start_cursor")
    val startCursor: String? = null,
)

@Serializable
internal data class DatabaseQueryRequestFilters(
    val or: List<DatabaseQueryRequestFilter>? = null,
    val and: List<DatabaseQueryRequestFilter>? = null,
)

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class DatabaseQueryRequestFilter(
    val property: String,
    val title: ApiTextDatabaseQueryFilter? = null,
    val text: ApiTextDatabaseQueryFilter? = null,
    val number: ApiNumberDatabaseQueryFilter? = null,
    val checkbox: ApiCheckboxDatabaseQueryFilter? = null,
    val select: ApiSelectDatabaseQueryFilter? = null,
    @SerialName("multi_select")
    val multiSelect: ApiMultiSelectDatabaseQueryFilter? = null,
    val date: ApiDateDatabaseQueryFilter? = null,
    val people: ApiPeopleDatabaseQueryFilter? = null,
    val files: ApiFilesDatabaseQueryFilter? = null,
    val url: ApiTextDatabaseQueryFilter? = null,
    val email: ApiTextDatabaseQueryFilter? = null,
    @SerialName("phone_number")
    val phoneNumber: ApiTextDatabaseQueryFilter? = null,
    val relation: ApiRelationDatabaseQueryFilter? = null,
    val formula: ApiFormulaDatabaseQueryFilter? = null,
    @SerialName("created_by")
    val createdBy: ApiPeopleDatabaseQueryFilter? = null,
    @SerialName("created_time")
    val createdTime: ApiDateDatabaseQueryFilter? = null,
    @SerialName("last_edited_by")
    val lastEditedBy: ApiPeopleDatabaseQueryFilter? = null,
    @SerialName("last_edited_time")
    val lastEditedTime: ApiDateDatabaseQueryFilter? = null,
)

internal fun DatabaseQueryPropertyFilter.toApi(): DatabaseQueryRequestFilter {
    return DatabaseQueryRequestFilter(
        property = propertyIdOrName,
        title = (this as? DatabaseQueryPropertyFilter.Title)?.predicate?.toApi(),
        text = (this as? DatabaseQueryPropertyFilter.Text)?.predicate?.toApi(),
        number = (this as? DatabaseQueryPropertyFilter.Number)?.predicate?.toApi(),
        checkbox = (this as? DatabaseQueryPropertyFilter.Checkbox)?.predicate?.toApi(),
        select = (this as? DatabaseQueryPropertyFilter.Select)?.predicate?.toApi(),
        multiSelect = (this as? DatabaseQueryPropertyFilter.MultiSelect)?.predicate?.toApi(),
        date = (this as? DatabaseQueryPropertyFilter.Date)?.predicate?.toApi(),
        people = (this as? DatabaseQueryPropertyFilter.People)?.predicate?.toApi(),
        files = (this as? DatabaseQueryPropertyFilter.Files)?.predicate?.toApi(),
        url = (this as? DatabaseQueryPropertyFilter.Url)?.predicate?.toApi(),
        email = (this as? DatabaseQueryPropertyFilter.Email)?.predicate?.toApi(),
        phoneNumber = (this as? DatabaseQueryPropertyFilter.PhoneNumber)?.predicate?.toApi(),
        relation = (this as? DatabaseQueryPropertyFilter.Relation)?.predicate?.toApi(),
        formula = (this as? DatabaseQueryPropertyFilter.Formula)?.predicate?.toApi(),
        createdBy = (this as? DatabaseQueryPropertyFilter.CreatedBy)?.predicate?.toApi(),
        createdTime = (this as? DatabaseQueryPropertyFilter.CreatedTime)?.predicate?.toApi(),
        lastEditedBy = (this as? DatabaseQueryPropertyFilter.LastEditedBy)?.predicate?.toApi(),
        lastEditedTime = (this as? DatabaseQueryPropertyFilter.LastEditedTime)?.predicate?.toApi()
    )
}

private fun DatabaseQueryPredicate.Text.toApi(): ApiTextDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Text.Equals -> ApiTextDatabaseQueryFilter(isEqual = value)
        is DatabaseQueryPredicate.Text.DoesNotEqual -> ApiTextDatabaseQueryFilter(doesNotEqual = value)
        is DatabaseQueryPredicate.Text.Contains -> ApiTextDatabaseQueryFilter(contains = value)
        is DatabaseQueryPredicate.Text.DoesNotContain -> ApiTextDatabaseQueryFilter(doesNotContain = value)
        is DatabaseQueryPredicate.Text.StartsWith -> ApiTextDatabaseQueryFilter(startsWith = value)
        is DatabaseQueryPredicate.Text.EndsWith -> ApiTextDatabaseQueryFilter(endsWith = value)
        is DatabaseQueryPredicate.Text.IsEmpty -> ApiTextDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Text.IsNotEmpty -> ApiTextDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Number.toApi(): ApiNumberDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Number.Equals ->
            ApiNumberDatabaseQueryFilter(isEquals = value.toDouble())
        is DatabaseQueryPredicate.Number.DoesNotEqual ->
            ApiNumberDatabaseQueryFilter(doesNotEqual = value.toDouble())
        is DatabaseQueryPredicate.Number.GreaterThan ->
            ApiNumberDatabaseQueryFilter(greaterThan = value.toDouble())
        is DatabaseQueryPredicate.Number.LessThan ->
            ApiNumberDatabaseQueryFilter(lessThan = value.toDouble())
        is DatabaseQueryPredicate.Number.GreaterThanOrEqualTo ->
            ApiNumberDatabaseQueryFilter(greaterThanOrEqualTo = value.toDouble())
        is DatabaseQueryPredicate.Number.LessThanOrEqualTo ->
            ApiNumberDatabaseQueryFilter(lessThanOrEqualTo = value.toDouble())
        is DatabaseQueryPredicate.Number.IsEmpty ->
            ApiNumberDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Number.IsNotEmpty ->
            ApiNumberDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Checkbox.toApi(): ApiCheckboxDatabaseQueryFilter {
    return if (isChecked) {
        ApiCheckboxDatabaseQueryFilter(isEquals = true)
    } else {
        ApiCheckboxDatabaseQueryFilter(doesNotEqual = true)
    }
}

private fun DatabaseQueryPredicate.Select.toApi(): ApiSelectDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Select.Equals -> ApiSelectDatabaseQueryFilter(isEquals = value)
        is DatabaseQueryPredicate.Select.DoesNotEqual -> ApiSelectDatabaseQueryFilter(doesNotEqual = value)
        is DatabaseQueryPredicate.Select.IsEmpty -> ApiSelectDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Select.IsNotEmpty -> ApiSelectDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.MultiSelect.toApi(): ApiMultiSelectDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.MultiSelect.Contains -> ApiMultiSelectDatabaseQueryFilter(contains = value)
        is DatabaseQueryPredicate.MultiSelect.DoesNotContain -> ApiMultiSelectDatabaseQueryFilter(doesNotContain = value)
        is DatabaseQueryPredicate.MultiSelect.IsEmpty -> ApiMultiSelectDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.MultiSelect.IsNotEmpty -> ApiMultiSelectDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Date.toApi(): ApiDateDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Date.Equals ->
            ApiDateDatabaseQueryFilter(isEquals = value.toApi())
        is DatabaseQueryPredicate.Date.Before ->
            ApiDateDatabaseQueryFilter(before = value.toApi())
        is DatabaseQueryPredicate.Date.After ->
            ApiDateDatabaseQueryFilter(after = value.toApi())
        is DatabaseQueryPredicate.Date.OnOrBefore ->
            ApiDateDatabaseQueryFilter(onOrBefore = value.toApi())
        is DatabaseQueryPredicate.Date.OnOrAfter ->
            ApiDateDatabaseQueryFilter(onOrAfter = value.toApi())
        is DatabaseQueryPredicate.Date.IsPastWeek ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsPastMonth ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsPastYear ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsNextWeek ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsNextMonth ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsNextYear ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Date.IsEmpty ->
            ApiDateDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Date.IsNotEmpty ->
            ApiDateDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.People.toApi(): ApiPeopleDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.People.Contains -> ApiPeopleDatabaseQueryFilter(contains = value)
        is DatabaseQueryPredicate.People.DoesNotContain -> ApiPeopleDatabaseQueryFilter(doesNotContain = value)
        is DatabaseQueryPredicate.People.IsEmpty -> ApiPeopleDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.People.IsNotEmpty -> ApiPeopleDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Files.toApi(): ApiFilesDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Files.IsEmpty -> ApiFilesDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Files.IsNotEmpty -> ApiFilesDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Relation.toApi(): ApiRelationDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Relation.Contains -> ApiRelationDatabaseQueryFilter(contains = value)
        is DatabaseQueryPredicate.Relation.DoesNotContain -> ApiRelationDatabaseQueryFilter(doesNotContains = value)
        is DatabaseQueryPredicate.Relation.IsEmpty -> ApiRelationDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Relation.IsNotEmpty -> ApiRelationDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Formula.toApi(): ApiFormulaDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Formula.Text ->
            ApiFormulaDatabaseQueryFilter(text = this.toFormulaApi())
        is DatabaseQueryPredicate.Formula.Checkbox ->
            ApiFormulaDatabaseQueryFilter(checkbox = this.toFormulaApi())
        is DatabaseQueryPredicate.Formula.Number ->
            ApiFormulaDatabaseQueryFilter(number = this.toFormulaApi())
        is DatabaseQueryPredicate.Formula.Date ->
            ApiFormulaDatabaseQueryFilter(date = this.toFormulaApi())
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Formula.Text.toFormulaApi(): ApiTextDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Formula.Text.Equals ->
            ApiTextDatabaseQueryFilter(isEqual = value)
        is DatabaseQueryPredicate.Formula.Text.DoesNotEqual ->
            ApiTextDatabaseQueryFilter(doesNotEqual = value)
        is DatabaseQueryPredicate.Formula.Text.Contains ->
            ApiTextDatabaseQueryFilter(contains = value)
        is DatabaseQueryPredicate.Formula.Text.DoesNotContain ->
            ApiTextDatabaseQueryFilter(doesNotContain = value)
        is DatabaseQueryPredicate.Formula.Text.StartsWith ->
            ApiTextDatabaseQueryFilter(startsWith = value)
        is DatabaseQueryPredicate.Formula.Text.EndsWith ->
            ApiTextDatabaseQueryFilter(endsWith = value)
        is DatabaseQueryPredicate.Formula.Text.IsEmpty ->
            ApiTextDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Formula.Text.IsNotEmpty ->
            ApiTextDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Formula.Checkbox.toFormulaApi(): ApiCheckboxDatabaseQueryFilter {
    return if (isChecked) {
        ApiCheckboxDatabaseQueryFilter(isEquals = true)
    } else {
        ApiCheckboxDatabaseQueryFilter(doesNotEqual = true)
    }
}

private fun DatabaseQueryPredicate.Formula.Number.toFormulaApi(): ApiNumberDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Formula.Number.Equals ->
            ApiNumberDatabaseQueryFilter(isEquals = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.DoesNotEqual ->
            ApiNumberDatabaseQueryFilter(doesNotEqual = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.GreaterThan ->
            ApiNumberDatabaseQueryFilter(greaterThan = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.LessThan ->
            ApiNumberDatabaseQueryFilter(lessThan = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.GreaterThanOrEqualTo ->
            ApiNumberDatabaseQueryFilter(greaterThanOrEqualTo = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.LessThanOrEqualTo ->
            ApiNumberDatabaseQueryFilter(lessThanOrEqualTo = value.toDouble())
        is DatabaseQueryPredicate.Formula.Number.IsEmpty ->
            ApiNumberDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Formula.Number.IsNotEmpty ->
            ApiNumberDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}

private fun DatabaseQueryPredicate.Formula.Date.toFormulaApi(): ApiDateDatabaseQueryFilter {
    return when (this) {
        is DatabaseQueryPredicate.Formula.Date.Equals ->
            ApiDateDatabaseQueryFilter(isEquals = value.toApi())
        is DatabaseQueryPredicate.Formula.Date.Before ->
            ApiDateDatabaseQueryFilter(before = value.toApi())
        is DatabaseQueryPredicate.Formula.Date.After ->
            ApiDateDatabaseQueryFilter(after = value.toApi())
        is DatabaseQueryPredicate.Formula.Date.OnOrBefore ->
            ApiDateDatabaseQueryFilter(onOrBefore = value.toApi())
        is DatabaseQueryPredicate.Formula.Date.OnOrAfter ->
            ApiDateDatabaseQueryFilter(onOrAfter = value.toApi())
        is DatabaseQueryPredicate.Formula.Date.IsPastWeek ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsPastMonth ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsPastYear ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsNextWeek ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsNextMonth ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsNextYear ->
            ApiDateDatabaseQueryFilter(pastWeek = mapOf())
        is DatabaseQueryPredicate.Formula.Date.IsEmpty ->
            ApiDateDatabaseQueryFilter(isEmpty = true)
        is DatabaseQueryPredicate.Formula.Date.IsNotEmpty ->
            ApiDateDatabaseQueryFilter(isNotEmpty = true)
        else -> throw IllegalStateException()
    }
}