package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
36. Valid Sudoku
Medium
9.4K
971
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 * */

class ValidSudokuTask : Task2<Array<CharArray>, Boolean> {

    override fun exec(input: Array<CharArray>): Boolean =
        isValidSudoku(board = input)

    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        var row = 0
        while (row < 9) {
            var column = 0
            while (column < 9) {
                val char = board[row][column]
                if (char == '.') {
                    column++
                    continue
                }
                val checkRow = board[row].count { it == char }
                val checkColumn = (0..8).count { board[it][column] == char }

                if (checkRow > 1 || checkColumn > 1)
                    return false
                column++
            }
            println()
            row++
        }

        return true
    }
}