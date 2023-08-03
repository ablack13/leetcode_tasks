package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 * */
class LongestCommonPrefixTask : Task2<Array<String>, String> {

    override fun exec(input: Array<String>): String =
        longestCommonPrefix(strs = input)

    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) {
            return strs.first()
        }
        val shortestWord = strs.minBy { it.length }
        requireNotNull(shortestWord)
        val result: Array<Char> = Array(shortestWord.length) { '-' }

        shortestWord.forEachIndexed { index, char ->
            if (strs.all { it[index] == char }) {
                result[index] = char
            } else {
                return result.filterNot { it == '-' }.joinToString(separator = "")
            }
        }
        return ""
    }
}