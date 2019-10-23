package org.echocat.kata.java.part1

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class MainAppUnitTest {

    @Test
    fun testGetHelloWorldText() {
        assertThat(MainApp.getHelloWorldText(), `is`("Hello world!"))
    }

}
