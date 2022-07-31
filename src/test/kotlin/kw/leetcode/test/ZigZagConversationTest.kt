package kw.leetcode.test

import kw.leetcode.impl.ZigZagConversationTask
import org.junit.Assert
import org.junit.Test

class ZigZagConversationTest {
    data class Data(
        val input: String,
        val numRows: Int,
        val expected: String
    )

    private val data: List<Data> =
        listOf(
            Data(
                input = "PAYPALISHIRING",
                numRows = 4,
                expected = "PINALSIGYAHRPI"
            ),
            Data(
                input = "PAYPALISHIRING",
                numRows = 3,
                expected = "PAHNAPLSIIGYIR"
            ),
            Data(
                input = "A",
                numRows = 1,
                expected = "A"
            ),
            Data(
                input = "AB",
                numRows = 1,
                expected = "AB"
            )
        )

    @Test
    fun start() {
        data.forEach {
            val actual = ZigZagConversationTask(
                input = it.input,
                numRows = it.numRows
            ).exec()
            Assert.assertEquals("input->${it.input}", it.expected, actual)
        }
    }
}