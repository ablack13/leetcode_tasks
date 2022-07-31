package kw.leetcode.common

interface Task2<T, R> {
    fun exec(input: T): R
}