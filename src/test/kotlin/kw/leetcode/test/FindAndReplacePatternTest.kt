package kw.leetcode.test

import kw.leetcode.impl.FindAndReplacePatternTask
import org.junit.Assert
import org.junit.Test

class FindAndReplacePatternTest {
    data class TestData(
        val input: List<String>,
        val pattern: String,
        val result: List<String>
    )
    private val data = listOf(
        TestData(
            input = listOf("a", "b", "c"),
            pattern = "a",
            result = listOf("a", "b", "c")
        ),
        TestData(
            input = listOf("abc", "deq", "mee", "aqq", "dkd", "ccc"),
            pattern = "abb",
            result = listOf("mee", "aqq")
        ),
    )

    @Test
    fun start() {
        data.forEach {
            val result = FindAndReplacePatternTask(it.input.toTypedArray(), it.pattern).exec()
            Assert.assertArrayEquals("input->${it.input}", it.result.toTypedArray(), result.toTypedArray())
        }
    }
}