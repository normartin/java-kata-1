package org.echocat.kata.java.part1

data class Book(
        override val title: String,
        val description: String,
        override val authors: Set<Author>,
        override val isbn: String
) : PrintMedium

fun importBooks(emailsToAuthor: (Collection<String>) -> Set<Author>): List<Book> = readCsv("books.csv")
        .map { cols ->
            val authors = emailsToAuthor(cols[2].split(","))
            Book(title = cols[0], description = cols[3], authors = authors, isbn = cols[1])
        }.toList()
