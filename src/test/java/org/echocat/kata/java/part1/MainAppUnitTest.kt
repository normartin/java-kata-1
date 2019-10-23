package org.echocat.kata.java.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDate

class MainAppUnitTest {

    @Test
    fun canImportAuthors() {
        assertThat(importAuthors()).contains(Author("null-walter@echocat.org", "Paul", "Walter"))
    }

    @Test
    fun canImportBooks() {
        val emailsToAuthor = authorsLookup(importAuthors())

        val firstBook = importBooks(emailsToAuthor).first()

        assertThat(firstBook.title).isEqualTo("Ich helfe dir kochen. Das erfolgreiche Universalkochbuch mit großem Backteil")
        assertThat(firstBook.isbn).isEqualTo("5554-5545-4518")
        assertThat(firstBook.description).startsWith("Auf der Suche nach einem Basiskochbuch")
    }

    @Test
    fun canImportMagazines() {
        val emailsToAuthor = authorsLookup(importAuthors())

        val firstMagazine = importMagazine(emailsToAuthor).first()

        assertThat(firstMagazine.title).isEqualTo("Beautiful cooking")
        assertThat(firstMagazine.isbn).isEqualTo("5454-5587-3210")
        assertThat(firstMagazine.publishedAt).isEqualTo(LocalDate.of(2011, 5, 21))
    }
}
