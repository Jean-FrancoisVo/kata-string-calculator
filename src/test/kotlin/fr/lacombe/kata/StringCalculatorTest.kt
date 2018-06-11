package fr.lacombe.kata

import org.junit.Test
import kotlin.test.assertEquals

class StringCalculatorTest {
    @Test
    fun `it can contain 0 number`() {
        assertEquals(add(""), 0)
    }

    @Test
    fun `it can contain 1 number`() {
        assertEquals(add("1"), 1)
    }

    @Test
    fun `it can contain 2 numbers`() {
        assertEquals(add("1,2"), 3)
    }

    @Test
    fun `it can contain 3 and 4 numbers or more`() {
        assertEquals(add("1,2,3"), 6)
        assertEquals(add("1,2,3,3"), 9)
        assertEquals(add("1,2,3,3,3"), 12)
    }
}

fun add(values: String): Int =
        if (values.isEmpty())
            0
        else
            values.split(",")
                    .map { e -> e.toInt() }
                    .reduce { acc, n -> acc + n }
