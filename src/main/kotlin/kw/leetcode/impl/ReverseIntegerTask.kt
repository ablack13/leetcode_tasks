package kw.leetcode.impl

import kw.leetcode.common.Task2

/*
7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
* */

class ReverseIntegerTask : Task2<Int, Int> {
    override fun exec(input: Int): Int =
        reverse(x = input)

    private fun reverse(x: Int): Int {
        var signedMult = 1
        var reversed = 0
        var num = x
        if (num < 0) {
            signedMult = -1
            num = signedMult*x
        }

        while (num != 0) {
            if (reversed * signedMult > Int.MAX_VALUE / 10 || reversed * signedMult < Int.MIN_VALUE / 10)
                return 0

            reversed = reversed * 10 + num % 10
            num /= 10
        }
        return reversed*signedMult
    }
}