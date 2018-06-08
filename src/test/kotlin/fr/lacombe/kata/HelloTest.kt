package fr.lacombe.kata

import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
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
}

fun add(values: String): Int {
    if (values.isEmpty())
        return 0
    val split = values.split(",")
    return if (split.size == 1) split[0].toInt() else split[0].toInt() + split[1].toInt()
}
