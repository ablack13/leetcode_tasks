package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?
 */

class PalindromeNumberTask : Task2<Int, Boolean> {

    override fun exec(input: Int): Boolean {
        if (input < 0) {
            return false
        }
        else if (input in 0..9) {
            return true
        }
        return isPalindrome(input = splitNumberToArray(number = input))
    }

    private fun isPalindrome(input: IntArray): Boolean {
        val isEvenNumber = input.lastIndex % 2 == 0
        var startIndex: Int
        var endIndex: Int

        val middleIndex = input.lastIndex / 2

        if (isEvenNumber) {
            startIndex = middleIndex - 1
            endIndex = middleIndex + 1
        } else {
            startIndex = middleIndex
            endIndex = middleIndex + 1
        }

        while (startIndex >= 0) {
            if (input[startIndex] != input[endIndex]) {
                return false
            }

            startIndex = startIndex.dec()
            endIndex = endIndex.inc()
        }
        return true
    }

    private fun splitNumberToArray(number: Int): IntArray {
        var num = number
        val count = getDigitCount(num)
        val array = IntArray(count)

        for (i in count - 1 downTo 0) {
            array[i] = num % 10
            num /= 10
        }

        return array
    }

    private fun getDigitCount(number: Int): Int {
        var num = number
        var count = 0

        while (num != 0) {
            num /= 10
            count++
        }

        return if (count == 0) 1 else count
    }
}