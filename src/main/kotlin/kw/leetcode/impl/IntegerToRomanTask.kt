package kw.leetcode.impl

import kw.leetcode.common.Task2
import java.lang.IllegalArgumentException

/**
12. Integer to Roman

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.


Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
 */

class IntegerToRomanTask : Task2<Int, String> {

    override fun exec(input: Int): String =
        intToRoman(num = input)

    private fun intToRoman(num: Int): String {
        if (num < 1 || num > 3999) {
            throw IllegalArgumentException("Number [$num] can't less than 1 and can't be more than 3999")
        }

        return buildString {
            calc(
                count = num / 1000,
                primary = 'M'
            ) {
                append(it)
            }
            calc(
                count = (num % 1000) / 100,
                primary = 'C',
                five = 'D',
                nineSuffix = 'M'
            ) {
                append(it)
            }

            calc(
                count = (num % 100) / 10,
                primary = 'X',
                five = 'L',
                nineSuffix = 'C'
            ) {
                append(it)
            }

            calc(
                count = num % 10,
                primary = 'I',
                five = 'V',
                nineSuffix = 'X'
            ) {
                append(it)
            }
        }
    }

    private inline fun calc(
        count: Int,
        primary: Char,
        five: Char = primary,
        nineSuffix: Char = primary,
        block: (Char) -> Unit
    ) {
        if (count > 0) {
            when (count) {
                4 -> {
                    block(primary)
                    block(five)
                }

                5 -> {
                    block(five)
                }

                in 6..8 -> {
                    block(five)
                    repeat(count - 5) {
                        block(primary)
                    }
                }

                9 -> {
                    block(primary)
                    block(nineSuffix)
                }

                else -> {
                    repeat(count) {
                        block(primary)
                    }
                }
            }
        }
    }
}