package kw.leetcode.test

import kw.leetcode.impl.StringToIntegerAtoiTask
import org.junit.Assert
import org.junit.Test

class StringToIntegerAtoiTest {
    private val data = listOf(
        "42" to 42,
        "   -42" to -42,
        "4193 with words" to 4193,
        "words and 987" to 0,
        "-91283472332" to -2147483648,
        "+1" to 1,
        "+-12" to 0,
        "00000-42a1234" to 0,
        "" to 0,
        "+" to 0,
        "-" to 0
    )

    @Test
    fun start() {
        val task = StringToIntegerAtoiTask()
        data.forEach {
            val actual = task.exec(s = it.first)
            Assert.assertEquals("input->'${it.first}'", it.second, actual)
        }
    }
}