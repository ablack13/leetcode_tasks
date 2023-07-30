package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
10. Regular Expression Matching

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */

class RegularExpressionMatchingTask : Task2<Pair<String, String>, Boolean> {

    private val lowerCaseEnglishWordsRegex = Regex("^[a-z]*$")
    private val lowerCaseEnglishWordsRegexWithPointAndStart = Regex("^[a-z.*]*$")

    override fun exec(input: Pair<String, String>): Boolean =
        isMatching(
            input = input.first,
            pattern = input.second
        )

    private fun isMatching(
        input: String,
        pattern: String
    ): Boolean {
        if (
            input.isEmpty()
            || pattern.isEmpty()
            || input.length > 20
            || pattern.length > 20
            || !input.matches(lowerCaseEnglishWordsRegex)
            || !pattern.matches(lowerCaseEnglishWordsRegexWithPointAndStart)
        ) {
            return false
        }

        return input.matches(Regex("^${pattern.replace(Regex("\\*+"), "*")}$"))
    }
}





