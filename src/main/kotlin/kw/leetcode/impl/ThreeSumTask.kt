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
        threeSum(num = input)

    private fun threeSum(num: IntArray): List<List<Int>> {
        println("--- input -> [${num.joinToString(", ")}]")
        val nums = num.sorted().toIntArray()

        val result: MutableList<List<Int>> = mutableListOf()
        var i = 0

        main@ while (i < nums.lastIndex) {
            var j = i + 1
            val usedIndexes = mutableSetOf<Int>()
            second@while (j < nums.lastIndex) {
                var k = j + 1
                third@ while (k <= nums.lastIndex){
                    if (i != j && i != k && j != k) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            var countIndexes = if (usedIndexes.contains(i)) 1 else 0
                            countIndexes += if (usedIndexes.contains(j)) 1 else 0
                            countIndexes += if (usedIndexes.contains(k)) 1 else 0

                            if (countIndexes < 2) {
                                println("[$i,$j,$k] {${nums[i]}, ${nums[j]}, ${nums[k]}}")
                                usedIndexes.addAll(listOf(i, j, k))
                                result.add(listOf(nums[i], nums[j], nums[k]))
                                k++
                                continue@third
                            } else {
                                j++
                                continue@second
                            }
                        }
                    }
                    k++
                }
                j++
            }
            i++
        }

        return result.distinctBy { it.toList() }
    }
}