package org.echocat.kata.java.part1

import java.time.LocalDate
import java.util.*


fun aBook(
        title: String = randomString("title"),
        isbn: String = randomString("isbn"),
        description: String = randomString("description"),
        authors: Set<Author> = emptySet()
): Book = Book(title = title, description = description, isbn = isbn, authors = authors)

fun aMagazine(
        title: String = randomString("title"),
        isbn: String = randomString("isbn"),
        publishedAt: LocalDate = LocalDate.of(2020, 1, 1),
        authors: Set<Author> = emptySet()
): Magazine = Magazine(title = title, publishedAt = publishedAt, isbn = isbn, authors = authors)

fun anAuthor(
        email: String = randomString("email"),
        firstName: String = randomString("firstName"),
        lastName: String = randomString("lastName")
): Author = Author(email = email, firstname = firstName, lastName = lastName)


fun randomString(prefix: String) = prefix + "-" + UUID.randomUUID()
