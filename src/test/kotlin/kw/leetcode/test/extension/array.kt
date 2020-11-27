package kw.leetcode.test.extension

val IntArray.asString: String
    get() = this.joinToString(prefix = "[", separator = ",", postfix = "]")
