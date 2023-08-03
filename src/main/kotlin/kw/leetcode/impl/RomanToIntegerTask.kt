package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * */
class RomanToIntegerTask : Task2<String, Int> {

    private val pattern = Regex("^[IVXLCDM]+$")
    private val cM = 'M'
    private val cD = 'D'
    private val cI = 'I'
    private val cX = 'X'
    private val cC = 'C'
    private val cL = 'L'
    private val cV = 'V'

    override fun exec(input: String): Int =
        romanToInt(input)

    private fun romanToInt(s: String): Int {
        if (s.isEmpty() || s.length > 15 || !s.matches(pattern)) {
            throw IllegalArgumentException("Input [$s] can't be empty or more than 15 symbols (inclusively)")
        }

        var result = 0
        var skipIndex = 0

        val onResult: ((Int, Int) -> Unit) = { addToResult, skipToIndex ->
            result += addToResult
            skipIndex = skipToIndex
        }

        repeat((s.indices).count()) {
            if (skipIndex != -1 && it >= skipIndex) {
                s.findRomanNumberLexeme(
                    index = it,
                    onResult = onResult
                )
            }
        }

        if (result > 3999) {
            throw IllegalArgumentException("Number [$result] can't can't be more than 3999")
        }
        return result
    }

    private fun String.findRomanNumberLexeme(
        index: Int,
        onResult: (
            addToResult: Int,
            skipToIndex: Int
        ) -> Unit
    ) {

        when (get(index)) {
            cM -> {
                onResult(1000, index.inc())
            }

            cD -> {
                onResult(500, index.inc())
            }

            cI -> {
                val nextIndex = index.inc()
                val next = getOrNull(nextIndex)

                if (next == null) {
                    onResult(1, -1)
                } else if (next == cI) {
                    val thirdIndex = nextIndex.inc()
                    val thirdI = getOrNull(thirdIndex)

                    if (thirdI == null || thirdI != cI) {
                        onResult(2, thirdIndex)
                    } else {
                        onResult(3, thirdIndex.inc())
                    }
                } else if (next == cV) {
                    onResult(4, nextIndex.inc())
                } else if (next == cX) {
                    onResult(9, nextIndex.inc())
                }
            }

            cX -> {/*L,C*/
                val nextIndex = index.inc()
                when (getOrNull(nextIndex)) {
                    null -> {
                        onResult(10, -1)
                    }

                    cL -> {
                        onResult(40, nextIndex.inc())
                    }

                    cC -> {
                        onResult(90, nextIndex.inc())
                    }

                    else -> {
                        onResult(10, nextIndex)
                    }
                }
            }

            cC -> {
                val nextIndex = index.inc()
                when (getOrNull(nextIndex)) {
                    null -> {
                        onResult(100, -1)
                    }

                    cD -> {
                        onResult(400, nextIndex.inc())
                    }

                    cM -> {
                        onResult(900, nextIndex.inc())
                    }

                    else -> {
                        onResult(100, nextIndex)
                    }
                }
            }

            cL -> {
                onResult(50, index.inc())
            }

            cV -> {
                val nextIndex = index.inc()
                if (getOrNull(nextIndex) == null) {
                    onResult(5, -1)
                } else {
                    if (getOrNull(nextIndex + 1) == null) {
                        onResult(6, -1)
                    } else {
                        if (getOrNull(nextIndex + 2) == null) {
                            onResult(7, -1)
                        } else {
                            onResult(8, -1)
                        }
                    }
                }
            }
        }
    }
}