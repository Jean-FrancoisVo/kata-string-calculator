package fr.lacombe.kata

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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

    @Test
    fun `it can accept line feed as separator`() {
        assertEquals(add("1\n2,3"), 6)
    }

    @Test
    fun `it fails with two separators consecutively`() {
        assertFailsWith<IllegalInputException> { add("1\n,") }
        assertFailsWith<IllegalInputException> { add("1\n,2") }
    }
}

fun add(values: String): Int =
        if (values.isEmpty())
            0
        else
            values.split(",", "\n")
                    .map { e ->
                        try {
                            e.toInt()
                        } catch (nfe: NumberFormatException) {
                            throw IllegalInputException()
                        }
                    }
                    .reduce { acc, n -> acc + n }

class IllegalInputException : Exception()