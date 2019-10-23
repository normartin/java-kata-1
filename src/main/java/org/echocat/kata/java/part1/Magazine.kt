package org.echocat.kata.java.part1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

private val germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN)

data class Magazine(
        override val title: String,
        val publishedAt: LocalDate,
        override val authors: Set<Author>,
        override val isbn: String
) : PrintMedium

fun importMagazine(authorLookup: (Collection<String>) -> Set<Author>): List<Magazine> = readCsv("magazines.csv")
        .map { cols ->
            val authors = authorLookup(cols[2].split(","))
            val publishedAt = LocalDate.parse(cols[3], germanFormatter)

            Magazine(title = cols[0], publishedAt = publishedAt, authors = authors, isbn = cols[1])
        }.toList()

