package kw.leetcode.test

import kw.leetcode.impl.IntegerToRomanTask
import org.junit.Assert
import org.junit.Test

class IntegerToRomanTest {

    private val data = listOf(
        1 to "I",
        3 to "III",
        58 to "LVIII",
        1994 to "MCMXCIV",
        2396 to "MMCCCXCVI",
        3999 to "MMMCMXCIX",
        392 to "CCCXCII",
        666 to "DCLXVI",
        777 to "DCCLXXVII",
        1996 to "MCMXCVI"
    )
    private val task = IntegerToRomanTask()

    @Test
    fun start() {
        data.forEach { (num, expected) ->
            val actual = task.exec(input = num)

            Assert.assertEquals(
                "num -> [$num], expected -> [$expected], actual -> [$actual]",
                /* expected = */ expected,
                /* actual = */ actual
            )
        }
    }
}