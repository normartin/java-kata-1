package org.echocat.kata.java.part1

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


private val mapper = ObjectMapper().registerKotlinModule().registerModule(JavaTimeModule()) //.writerWithDefaultPrettyPrinter()

fun Any.asJson(): String = mapper.writeValueAsString(this)
