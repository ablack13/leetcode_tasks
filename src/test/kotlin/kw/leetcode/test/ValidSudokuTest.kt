package kw.leetcode.test

import kw.leetcode.impl.ValidSudokuTask
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidSudokuTest {

    private val data = listOf(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        ) to true,
        arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        ) to false,
        arrayOf(
            charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
            charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
            charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
            charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
            charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
            charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.')
        ) to false
    )
    private val task = ValidSudokuTask()

    @Test
    fun start() {
        data.forEachIndexed { index, (input, expected) ->
            val actual = task.exec(input = input)

            assertEquals(
                expected = expected,
                actual = actual,
                message = "[$index] case failed, expected -> $expected, actual -> $actual"
            )
        }
    }
}