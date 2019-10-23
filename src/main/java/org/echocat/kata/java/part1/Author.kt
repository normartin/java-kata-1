package org.echocat.kata.java.part1

data class Author(
        val email: String,
        val firstname: String,
        val lastName: String
)

fun importAuthors(): Set<Author> = readCsv("authors.csv").map { cols ->
    Author(email = cols[0], firstname = cols[1], lastName = cols[2])
}.toSet()

// returns a function that can be used to lookup authors by email address
fun authorsLookup(allAuthors: Set<Author>): (Collection<String>) -> Set<Author> {
    return { emails ->
        emails.map { email ->
            allAuthors.find { email == it.email } ?: throw RuntimeException("Author $email unknown")
        }.toSet()
    }
}
