package org.echocat.kata.java.part1

object MainApp {

    @JvmStatic
    fun main(args: Array<String>) {

        // 1.
        val authorLookUp = authorsLookup(importAuthors())
        val booksAndMagazines = BooksAndMagazines(
                books = importBooks(authorLookUp),
                magazines = importMagazine(authorLookUp)
        )

        // 2.
        // I am not sure what to expected output format should look like.

        // I guess that is not the expected way?
        println(booksAndMagazines)

        // we can do some JSON maybe?
        println(booksAndMagazines.asJson())

        println()
        println("3.")
        println("Looking up book by isbn")
        val bookIsbn = "3214-5698-7412"
        val magazineIsbn = "2365-5632-7854"

        println("""found book by $bookIsbn -> ${booksAndMagazines.findBookByIsbn(bookIsbn) ?: "NOT FOUND"}""")
        println("found book by $magazineIsbn -> " + (booksAndMagazines.findBookByIsbn(magazineIsbn) ?: "NOT FOUND"))
        println()
        println("found magazine by $bookIsbn -> " + (booksAndMagazines.findMagazineByIsbn(bookIsbn) ?: "NOT FOUND"))
        println("found magazine by $magazineIsbn -> " + (booksAndMagazines.findMagazineByIsbn(magazineIsbn) ?: "NOT FOUND"))
        println()
        println("found printmedium by $bookIsbn -> " + (booksAndMagazines.findPrintMediumByIsbn(bookIsbn) ?: "NOT FOUND"))
        println("found printmedium by $magazineIsbn -> " + (booksAndMagazines.findPrintMediumByIsbn(magazineIsbn) ?: "NOT FOUND"))

        println()
        println("4.")
        val authorEmail = "null-ferdinand@echocat.org"
        println("found medium by " + authorEmail + " -> " + booksAndMagazines.findPrintMediumByAuthorsEmails(authorEmail).joinToString { it.title })

        // 5.
        println()
        println("5.")
        println("All print mediums sorted by title")
        println(booksAndMagazines.booksAndMagazinesSorted().joinToString("\n"))

        println("If you like JSON for all the details?")
        println(booksAndMagazines.booksAndMagazinesSorted().asJson())
    }

}
