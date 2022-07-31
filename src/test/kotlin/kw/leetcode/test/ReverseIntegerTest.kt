package kw.leetcode.test

import kw.leetcode.impl.ReverseIntegerTask
import org.junit.Assert
import org.junit.Test

class ReverseIntegerTest {
    private val data = listOf(
        123 to 321,
        -123 to -321,
        120 to 21,
        Int.MAX_VALUE to 0,
        Int.MIN_VALUE to 0,
        0 to 0,
        1534236469 to 0
    )

    @Test
    fun start() {
        val task = ReverseIntegerTask()
        data.forEach {
            val actual = task.exec(input = it.first)
            Assert.assertEquals("input->${it.first}", it.second, actual)
        }
    }
}