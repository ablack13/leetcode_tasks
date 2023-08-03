package kw.leetcode.test

import kw.leetcode.impl.RomanToIntegerTask
import org.junit.Assert
import org.junit.Test

class RomanToIntegerTest {
    private val data = listOf(
        "I" to 1,
        "III" to 3,
        "V" to 5,
        "VI" to 6,
        "VIII" to 8,
        "XVIII" to 18,
        "LVIII" to 58,
        "MCMXCIV" to 1994,
        "MMCCCXCVI" to 2396,
        "MMMCMXCIX" to 3999,
        "CCCXCII" to 392,
        "DCLXVI" to 666,
        "DCCLXXVII" to 777,
        "MCMXCVI" to 1996,
        "MCMXCIX" to 1999
    )
    private val task = RomanToIntegerTask()

    @Test
    fun start() {
        data.forEach { (input, expected) ->
            val actual = task.exec(input = input)

            Assert.assertEquals(
                "roman -> [$input], expected -> [$expected], actual -> [$actual]",
                /* expected = */ expected,
                /* actual = */ actual
            )
        }
    }
}