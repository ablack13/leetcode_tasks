package kw.leetcode.test

import kw.leetcode.impl.PalindromeNumberTask
import org.junit.Assert
import org.junit.Test

class PalindromeNumberTest {

    private val data = listOf(
        0 to true,
        1 to true,
        121 to true,
        1212 to false,
        1333 to false,
        1331 to true,
        313312 to false,
        8183818 to true,
        10 to false,
        11 to true
    )

    private val task: PalindromeNumberTask = PalindromeNumberTask()

    @Test
    fun start() {
        data.forEach { (number, expected) ->
            val actual = task.exec(input = number)
            Assert.assertEquals(
                /* expected = */ expected,
                /* actual = */ actual
            )
        }
    }
}