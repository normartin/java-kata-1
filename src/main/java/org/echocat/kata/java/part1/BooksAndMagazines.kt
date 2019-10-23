package org.echocat.kata.java.part1

data class BooksAndMagazines(val books: List<Book>, val magazines: List<Magazine>) {
    fun findBookByIsbn(isbn: String): Book? = books.find { it.isbn == isbn }
    fun findMagazineByIsbn(isbn: String): Magazine? = magazines.find { it.isbn == isbn }
    fun findPrintMediumByIsbn(isbn: String): PrintMedium? = findBookByIsbn(isbn) ?: findMagazineByIsbn(isbn)

    fun findPrintMediumByAuthorsEmails(email: String) = (books + magazines).filter { printMedium ->
        printMedium.authors.map { author -> author.email }.contains(email)
    }

    // For human and languages that use none ASCII characters we should be case insensitive and use a Collator
    fun booksAndMagazinesSorted(): List<PrintMedium> = (books + magazines).sortedBy { it.title }
}
