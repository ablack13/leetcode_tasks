package kw.leetcode.test

import kw.leetcode.impl.LongestCommonPrefixTask
import org.junit.Assert
import org.junit.Test

class LongestCommonPrefixTest {

    private val data = listOf(
        arrayOf("flower", "flow", "flight") to "fl",
        arrayOf("dog", "racecar", "car") to "",
        arrayOf("dog") to "dog",
        arrayOf("rog", "rock", "romst", "roc") to "ro",
    )
    private val task = LongestCommonPrefixTask()

    @Test
    fun start() {
        data.forEach { (input, expected) ->
            val actual = task.exec(input = input)

            Assert.assertEquals(
                "[${input.joinToString(separator = ", ")}], expect -> [$expected], actual => [$actual]",
                /* expected = */ expected,
                /* actual = */ actual
            )
        }
    }
}