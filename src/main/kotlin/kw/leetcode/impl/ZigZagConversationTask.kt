package kw.leetcode.impl

import kw.leetcode.common.Task

/*
6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
* */

class ZigZagConversationTask(
    private val input: String,
    private val numRows: Int
) : Task<String> {
    override fun exec(): String =
        convert(
            s = input,
            numRows = numRows
        )

    private fun convert(
        s: String,
        numRows: Int
    ): String {
        val rows = MutableList(size = numRows, init = { mutableListOf<String>() })
        var currentRowIndex = 0
        val lastRowIndex = numRows - 1
        var invertDirection = false

        s.forEach {
            rows[currentRowIndex].add(it.toString())
            if (currentRowIndex == lastRowIndex)
                invertDirection = true
            else
                if (currentRowIndex == 0)
                    invertDirection = false
            currentRowIndex =
                if (invertDirection)
                    maxOf(0, currentRowIndex - 1)
                else
                    minOf(currentRowIndex + 1, lastRowIndex)
        }
        return rows.joinToString("") { it.joinToString("") }
    }
}