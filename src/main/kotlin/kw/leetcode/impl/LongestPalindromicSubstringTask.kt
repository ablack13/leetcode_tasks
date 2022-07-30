package kw.leetcode.impl

import kw.leetcode.common.Task

/*
5. Longest Palindromic Substring
Medium

20194

1163

Add to List

Share
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
* */

class LongestPalindromicSubstringTask(private val input: String) : Task<String> {
    override fun exec(): String =
        longestPalindrome(input = input)

    private fun longestPalindrome(input: String): String {
        val chars = input.toCharArray()
        var longestPalindrom = ""

        chars.forEachIndexed { index, char ->
            var palindrom = char.toString()
            var nextIndex = index + 1
            var nextChar = chars.getOrNull(nextIndex)
            if (nextChar != null) {
                while (char == nextChar) {
                    palindrom += nextChar
                    nextChar = chars.getOrNull(nextIndex + 1)
                    if (nextChar != null)
                        nextIndex += 1
                }
            }
            var prevIndex = index - 1
            var prevChar = chars.getOrNull(prevIndex)
            nextChar = chars.getOrNull(nextIndex)

            if (prevChar != null && nextChar != null && prevChar != char)
                while (prevChar == nextChar) {
                    palindrom = "$prevChar$palindrom$nextChar"

                    prevChar = chars.getOrNull(prevIndex - 1)
                    nextChar = chars.getOrNull(nextIndex + 1)
                    if (prevChar != null && nextChar != null) {
                        prevIndex -= 1
                        nextIndex += 1
                    }
                }
            if (palindrom.length > longestPalindrom.length)
                longestPalindrom = palindrom
        }
        return longestPalindrom
    }
}