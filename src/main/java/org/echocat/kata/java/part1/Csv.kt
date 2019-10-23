package org.echocat.kata.java.part1

import java.nio.charset.Charset

fun readCsv(filename: String): Sequence<List<String>> {
    // TODO: don't read all at once into memory
    val text = MainApp::class.java.getResource("./data/$filename").readText(Charset.forName("UTF-8"))

    val lines = text.splitToSequence("\n")
            .drop(1) // drop header
            .map { it.trim() }
            .filter { it.isNotBlank() }

    return lines.map {
        it.split(";")
    }
}
