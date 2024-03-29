package kw.leetcode.impl

import kw.leetcode.common.Task2

/**
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
class ThreeSumTask : Task2<IntArray, List<List<Int>>> {

    override fun exec(input: IntArray): List<List<Int>> =
        threeSum(nums = input)

    private fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        repeat((0..nums.size - 2).count()) { i ->
            if (i == 0 || nums[i] != nums[i - 1]) {
                var left = i + 1
                var right = nums.size - 1

                val num1 = nums[i]

                while (left < right) {
                    val num2 = nums[left]
                    val num3 = nums[right]

                    when {
                        num1 + num2 + num3 == 0 -> {
                            result.add(listOf(num1, num2, num3))

                            while (left < right && num2 == nums[left + 1]) left++
                            while (left < right && num3 == nums[right - 1]) right--

                            left--
                            right--
                        }

                        num2 + num3 > -num1 -> right--
                        else -> left++
                    }
                }
            }
        }
        return result
    }
}