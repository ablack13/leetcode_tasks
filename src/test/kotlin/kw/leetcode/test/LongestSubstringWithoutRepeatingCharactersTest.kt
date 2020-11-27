package kw.leetcode.test

import kw.leetcode.impl.LongestSubstringWithoutRepeatingCharactersTask
import org.junit.Assert
import org.junit.Test

/**
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * */

class LongestSubstringWithoutRepeatingCharactersTest {
    val dataSet = listOf(
        "abcabcbb" to 3,
        "bbbbb" to 1,
        "pwwkew" to 3,
        "" to 0,
        " " to 1,
        "c" to 1,
        "au" to 2,
        "bfw" to 3,
        "bf1 saas" to 6
    )

    @Test
    fun start() {
        dataSet.forEach { data ->
            val result = LongestSubstringWithoutRepeatingCharactersTask(data.first).exec()
            println("input->`${data.first}` result->$result check->${data.second}")
            Assert.assertEquals("input->`${data.first}`",result, data.second)
        }
    }
}