package com.velkonost.knotion.model.database.query.filter

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.date.DateOrDateTime

interface DatabaseQueryPredicate {
    interface Text : DatabaseQueryPredicate {
        data class Equals(
            val value: String,
        ) : Text

        data class DoesNotEqual(
            val value: String,
        ) : Text

        data class Contains(
            val value: String,
        ) : Text

        data class DoesNotContain(
            val value: String,
        ) : Text

        data class StartsWith(
            val value: String,
        ) : Text

        data class EndsWith(
            val value: String,
        ) : Text

        object IsEmpty : Text

        object IsNotEmpty : Text
    }

    interface Number : DatabaseQueryPredicate {
        data class Equals(
            val value: kotlin.Number,
        ) : Number

        data class DoesNotEqual(
            val value: kotlin.Number,
        ) : Number

        data class GreaterThan(
            val value: kotlin.Number,
        ) : Number

        data class LessThan(
            val value: kotlin.Number,
        ) : Number

        data class GreaterThanOrEqualTo(
            val value: kotlin.Number,
        ) : Number

        data class LessThanOrEqualTo(
            val value: kotlin.Number,
        ) : Number

        object IsEmpty : Number

        object IsNotEmpty : Number
    }

    data class Checkbox(
        val isChecked: Boolean,
    ) : DatabaseQueryPredicate

    interface Select : DatabaseQueryPredicate {
        data class Equals(
            val value: String,
        ) : Select

        data class DoesNotEqual(
            val value: String,
        ) : Select

        object IsEmpty : Select

        object IsNotEmpty : Select
    }

    interface MultiSelect : DatabaseQueryPredicate {
        data class Contains(
            val value: String,
        ) : MultiSelect

        data class DoesNotContain(
            val value: String,
        ) : MultiSelect

        object IsEmpty : MultiSelect

        object IsNotEmpty : MultiSelect
    }

    interface Date : DatabaseQueryPredicate {
        data class Equals(
            val value: DateOrDateTime,
        ) : Date

        data class Before(
            val value: DateOrDateTime,
        ) : Date

        data class After(
            val value: DateOrDateTime,
        ) : Date

        data class OnOrBefore(
            val value: DateOrDateTime,
        ) : Date

        data class OnOrAfter(
            val value: DateOrDateTime,
        ) : Date

        object IsPastWeek : Date

        object IsPastMonth : Date

        object IsPastYear : Date

        object IsNextWeek : Date

        object IsNextMonth : Date

        object IsNextYear : Date

        object IsEmpty : Date

        object IsNotEmpty : Date
    }

    interface People : DatabaseQueryPredicate {
        data class Contains(
            val value: UuidString,
        ) : People

        data class DoesNotContain(
            val value: UuidString,
        ) : People

        object IsEmpty : People

        object IsNotEmpty : People
    }

    interface Files : DatabaseQueryPredicate {
        object IsEmpty : Files

        object IsNotEmpty : Files
    }

    interface Relation : DatabaseQueryPredicate {
        data class Contains(
            val value: UuidString,
        ) : Relation

        data class DoesNotContain(
            val value: UuidString,
        ) : Relation

        object IsEmpty : Relation

        object IsNotEmpty : Relation
    }

    interface Formula : DatabaseQueryPredicate {
        interface Text : Formula {
            data class Equals(
                val value: String,
            ) : Text

            data class DoesNotEqual(
                val value: String,
            ) : Text

            data class Contains(
                val value: String,
            ) : Text

            data class DoesNotContain(
                val value: String,
            ) : Text

            data class StartsWith(
                val value: String,
            ) : Text

            data class EndsWith(
                val value: String,
            ) : Text

            object IsEmpty : Text

            object IsNotEmpty : Text
        }

        data class Checkbox(
            val isChecked: Boolean,
        ) : Formula

        interface Number : Formula {
            data class Equals(
                val value: kotlin.Number,
            ) : Number

            data class DoesNotEqual(
                val value: kotlin.Number,
            ) : Number

            data class GreaterThan(
                val value: kotlin.Number,
            ) : Number

            data class LessThan(
                val value: kotlin.Number,
            ) : Number

            data class GreaterThanOrEqualTo(
                val value: kotlin.Number,
            ) : Number

            data class LessThanOrEqualTo(
                val value: kotlin.Number,
            ) : Number

            object IsEmpty : Number

            object IsNotEmpty : Number
        }

        interface Date : Formula {
            data class Equals(
                val value: DateOrDateTime,
            ) : Date

            data class Before(
                val value: DateOrDateTime,
            ) : Date

            data class After(
                val value: DateOrDateTime,
            ) : Date

            data class OnOrBefore(
                val value: DateOrDateTime,
            ) : Date

            data class OnOrAfter(
                val value: DateOrDateTime,
            ) : Date

            object IsPastWeek : Date

            object IsPastMonth : Date

            object IsPastYear : Date

            object IsNextWeek : Date

            object IsNextMonth : Date

            object IsNextYear : Date

            object IsEmpty : Date

            object IsNotEmpty : Date
        }
    }
}
