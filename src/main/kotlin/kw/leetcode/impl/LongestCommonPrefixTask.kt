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
        var prefix = ""

        strs.minBy { it.length }
            ?.forEachIndexed { index, char ->
                if (strs.all { it[index] == char }) {
                    prefix += char
                } else {
                    return prefix
                }
            }
        return prefix
    }
}