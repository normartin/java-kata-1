package org.echocat.kata.java.part1

object MainApp {

    fun getHelloWorldText() = "Hello world!"

    @JvmStatic
    fun main(args: Array<String>) {
        println(getHelloWorldText())
    }

}
