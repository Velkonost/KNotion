package com.velkonost.knotion.model.database.query.filter

interface DatabaseQueryPropertyFilter {
    val propertyIdOrName: String
    val predicate: DatabaseQueryPredicate

    data class Title(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Text,
    ) : DatabaseQueryPropertyFilter

    data class Text(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Text,
    ) : DatabaseQueryPropertyFilter

    data class Number(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Number,
    ) : DatabaseQueryPropertyFilter

    data class Checkbox(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Checkbox,
    ) : DatabaseQueryPropertyFilter

    data class Select(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Select,
    ) : DatabaseQueryPropertyFilter

    data class MultiSelect(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.MultiSelect,
    ) : DatabaseQueryPropertyFilter

    data class Date(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Date,
    ) : DatabaseQueryPropertyFilter

    data class People(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.People,
    ) : DatabaseQueryPropertyFilter

    data class Files(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Files,
    ) : DatabaseQueryPropertyFilter

    data class Relation(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Relation,
    ) : DatabaseQueryPropertyFilter

    data class Formula(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Formula,
    ) : DatabaseQueryPropertyFilter

    data class Url(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Text,
    ) : DatabaseQueryPropertyFilter

    data class Email(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Text,
    ) : DatabaseQueryPropertyFilter

    data class PhoneNumber(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Text,
    ) : DatabaseQueryPropertyFilter

    data class CreatedBy(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.People,
    ) : DatabaseQueryPropertyFilter

    data class CreatedTime(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Date,
    ) : DatabaseQueryPropertyFilter

    data class LastEditedBy(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.People,
    ) : DatabaseQueryPropertyFilter

    data class LastEditedTime(
        override val propertyIdOrName: String,
        override val predicate: DatabaseQueryPredicate.Date,
    ) : DatabaseQueryPropertyFilter
}