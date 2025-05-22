package com.velkonost.knotion.model.database.query

import com.velkonost.knotion.model.database.query.filter.DatabaseQueryPropertyFilter

class DatabaseQuery {
    internal val allFilters = mutableSetOf<DatabaseQueryPropertyFilter>()
    internal val anyFilters = mutableSetOf<DatabaseQueryPropertyFilter>()

    fun all(vararg filter: DatabaseQueryPropertyFilter): DatabaseQuery {
        allFilters += filter
        return this
    }

    fun any(vararg filter: DatabaseQueryPropertyFilter): DatabaseQuery {
        anyFilters += filter
        return this
    }

    override fun toString(): String {
        return "DatabaseQueryImpl(allFilters=$allFilters, anyFilters=$anyFilters)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as DatabaseQuery

        if (allFilters != other.allFilters) return false
        if (anyFilters != other.anyFilters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = allFilters.hashCode()
        result = 31 * result + anyFilters.hashCode()
        return result
    }
}
