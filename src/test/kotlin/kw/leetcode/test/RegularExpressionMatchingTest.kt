package kw.leetcode.test

import kw.leetcode.impl.RegularExpressionMatchingTask
import org.junit.Assert
import org.junit.Test

class RegularExpressionMatchingTest {

    private data class Data(
        val input: String,
        val pattern: String,
        val expected: Boolean
    )

    private val data = listOf(
        Data("aa", "a", false),
        Data("aa", "a*", true),
        Data("ab", ".*", true),
        Data("ab1", ".*", false),
        Data("abb", "a.*", true),
        Data("ababababz", "abab.babz", true),
        Data("bb", "*", false),
        Data("", ".*", false),
        Data("abc", "a***abc", true),


    )

    private val task = RegularExpressionMatchingTask()

    @Test
    fun start() {
        data.forEach {
            val actual = task.exec(input = it.input to it.pattern)
            Assert.assertEquals(
                "input -> [${it.input}] pattern -> [${it.pattern}]",
                /* expected = */ it.expected,
                /* actual = */ actual
            )
        }
    }
}