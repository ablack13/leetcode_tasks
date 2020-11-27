package kw.leetcode.test

import kw.leetcode.impl.TwoSumTask
import kw.leetcode.test.extension.asString
import org.junit.Test

class TwoSumTest {
    private data class Data(
        val input: IntArray,
        val target: Int,
        val result: IntArray
    )

    private val dataSet = listOf(
        Data(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
        Data(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
        Data(intArrayOf(3, 3), 6, intArrayOf(0, 1))
    )

    @Test
    fun start() {
        dataSet.forEach { data ->
            val result = TwoSumTask(data.input, data.target).exec()
            println(
                "input->${data.input.asString}" +
                        " target->${data.target}" +
                        " result->${result.asString}"
            )
        }
    }

   }