package org.echocat.kata.java.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BooksAndMagazinesTest {

    @Test
    fun `can find print medium by isbn`() {

        val booksAndMagazines = BooksAndMagazines(
                books = listOf(
                        aBook(isbn = "b1", title = "the title"),
                        aBook(isbn = "b2")
                ),
                magazines = listOf(
                        aMagazine(isbn = "m1"),
                        aMagazine(isbn = "m2")
                )
        )

        assertThat(booksAndMagazines.findPrintMediumByIsbn("b1")).isNotNull
        assertThat(booksAndMagazines.findPrintMediumByIsbn("b1")!!.isbn).isEqualTo("b1")
        assertThat(booksAndMagazines.findPrintMediumByIsbn("b1")!!.title).isEqualTo("the title")

    }

    @Test
    fun `can find print medium by authors email`() {

        val author = anAuthor(email = "a@a.de")

        val booksAndMagazines = BooksAndMagazines(
                books = listOf(
                        aBook(authors = setOf(author), title = "b1"),
                        aBook(authors = setOf(anAuthor()))
                ),
                magazines = listOf(
                        aMagazine(authors = setOf(author, anAuthor()), title = "m1")
                )
        )

        assertThat(booksAndMagazines.findPrintMediumByAuthorsEmails("a@a.de")).hasSize(2)
        assertThat(booksAndMagazines.findPrintMediumByAuthorsEmails("a@a.de").map { it.title }).containsExactly("b1", "m1")
    }

    @Test
    fun `can return books and magazines sorted`() {
        val booksAndMagazines = BooksAndMagazines(
                books = listOf(
                        aBook(title = "zb"),
                        aBook(title = "ab")
                ),
                magazines = listOf(
                        aMagazine(title = "gm")
                )
        )

        assertThat(booksAndMagazines.booksAndMagazinesSorted().map { it.title }).containsExactly("ab", "gm", "zb")
    }


}
