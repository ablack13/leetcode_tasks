package kw.leetcode.impl

import kw.leetcode.common.Task

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
[2->4->3]
[5->6->4]
[7->0->8]

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

* */
class AddTwoNumbersTask(private val l1: ListNode?, private val l2: ListNode?) : Task<ListNode?> {

    override fun exec(): ListNode? =
        addTwoNumbers(l1, l2)

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var currentL1 = l1
        var currentL2 = l2
        var currentResult: ListNode? = null
        do {
            val val1 = currentL1?.`val` ?: 0
            val val2 = currentL2?.`val` ?: 0
            val val3 = val1 + val2

            if (currentResult == null) {
                result = ListNode(val3)
                currentResult = result
            } else {
                currentResult.next = ListNode(val3)
            }
            currentL1 = currentL1?.next
            currentL2 = currentL2?.next
            if (currentResult.next != null) {
                if (currentResult.`val` >= 10) {
                    currentResult.`val` -= 10
                    currentResult.next?.`val` = 1 + (currentResult.next?.`val` ?: 0)
                }
                currentResult = currentResult.next
            }
            if (currentL1 == null && currentL2 == null) {
                var lastValue = currentResult?.`val` ?: 0
                if (lastValue >= 10) {
                    lastValue -= 10
                    currentResult?.`val` = lastValue
                    currentResult?.next = ListNode(1)
                }
            }
        } while (currentL1 != null || currentL2 != null)
        return result
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}