package kw.leetcode.test

import kw.leetcode.impl.ThreeSumTask
import kotlin.test.Test
import kotlin.test.assertContains

class ThreeSumTest {
    private val data = listOf(
        arrayOf(1, -1, -1, 0) to listOf(listOf(-1, 0, 1)),
        arrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4) to listOf(
            listOf(-4, 0, 4),
            listOf(-4, 1, 3),
            listOf(-3, -1, 4),
            listOf(-3, 0, 3),
            listOf(-3, 1, 2),
            listOf(-2, -1, 3),
            listOf(-2, 0, 2),
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        ),
        arrayOf(-2, 0, 0, 2, 2) to listOf(listOf(-2, 0, 2)),
        arrayOf(3, 0, -2, -1, 1, 2) to listOf(listOf(-2, -1, 3), listOf(-2, 0, 2), listOf(-1, 0, 1)),
        arrayOf(-1, 0, 1, 0) to listOf(listOf(-1, 1, 0)),
        arrayOf(-2, 0, 1, 1, 2) to listOf(listOf(-2, 0, 2), listOf(-2, 1, 1)),
        arrayOf(-1, 0, 1, 2, -1, -4) to listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
        arrayOf(0, 1, 1) to emptyList(),
        arrayOf(0, 0, 0) to listOf(listOf(0, 0, 0))
    )
    private val task = ThreeSumTask()

    @Test
    fun start() {
        data.forEach { (input, expected) ->
            val exp = expected.map { it.sorted() }
            val result = task.exec(input = input.toIntArray())
            result.forEach { elem ->
                assertContains(
                    iterable = exp,
                    element = elem
                )
            }
            println("input -> [${input.joinToString(", ")}], result -> $result")
        }
    }
}