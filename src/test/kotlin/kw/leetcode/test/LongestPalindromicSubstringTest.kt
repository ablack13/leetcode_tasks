package kw.leetcode.test

import kw.leetcode.impl.LongestPalindromicSubstringTask
import org.junit.Assert
import org.junit.Test

class LongestPalindromicSubstringTest {

    private val data = listOf(
        "a" to "a",
        "ccc" to "ccc",
        "babad" to "bab",
        "cbbd" to "bb",
        "saadbbbdad" to "adbbbda",
        "cbbasdskdaadkskjhdassdskdaadkjhskd" to "skdaadks",
        "xaabacxcabaaxcabaax" to "xaabacxcabaax"
    )

    @Test
    fun start() {
        data.forEach {
            val result = LongestPalindromicSubstringTask(input = it.first).exec()
            val expected = it.second
            val actual = result
            Assert.assertEquals("input=>${it.first}", expected, actual)
        }
    }
}