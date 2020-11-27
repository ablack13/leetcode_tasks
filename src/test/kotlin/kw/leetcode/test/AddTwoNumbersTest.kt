package kw.leetcode.test

import kw.leetcode.impl.AddTwoNumbersTask
import kw.leetcode.impl.ListNode
import org.junit.Assert
import org.junit.Test

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
[2->4->3]
[5->6->4]
[7->0->8]

Input:
l1 = [2,4,3],
l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

* */
class AddTwoNumbersTest {
    private val l1 =
        node(2) {
            node(4) {
                node(3)
            }
        }
    private val l2 =
        node(5) {
            node(6) {
                node(4)
            }
        }
    private val result1 = "708"
    private val l01 = node(0)
    private val l011 = node(0)
    private val result2 = "0"
    private val l11 =
        node(9) {
            node(9) {
                node(9) {
                    node(9) {
                        node(9) {
                            node(9) {
                                node(9)
                            }
                        }
                    }
                }
            }
        }
    private val l21 =
        node(9) {
            node(9) {
                node(9) {
                    node(9)
                }
            }
        }
    private val result3 = "89990001"

    @Test
    fun start() {
        val res = AddTwoNumbersTask(l1, l2).exec()
        val res2 = AddTwoNumbersTask(l01, l011).exec()
        val res3 = AddTwoNumbersTask(l11, l21).exec()

        Assert.assertEquals("res->${res.asStr()}", res.asStr(), result1)
        Assert.assertEquals("res2->${res2.asStr()}", res2.asStr(), result2)
        Assert.assertEquals("res3->${res3.asStr()}", res3.asStr(), result3)
    }

    private fun ListNode?.asStr(): String {
        var current = this
        var result = current?.`val`.toString()
        while (current?.next != null) {
            current = current.next
            result += current?.`val`
        }
        return result
    }

    private fun node(value: Int, op: (() -> ListNode)? = null): ListNode {
        return ListNode(value).apply {
            if (op != null)
                this.next = op.invoke()
        }
    }
}