package kw.leetcode.impl

import kw.leetcode.common.Task2
import kotlin.math.max
import kotlin.math.min

/**
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 10^5 (100,000)
0 <= height[i] <= 104
 */
class ContainerWithMostWaterTask : Task2<IntArray, Int> {

    override fun exec(input: IntArray): Int =
        maxArea(height = input)

    private fun maxArea(height: IntArray): Int {
        var square = 0
        var startIndex = 0
        var endIndex = height.size - 1

        while (startIndex < endIndex) {
            square = max(square, (endIndex - startIndex) * min(height[startIndex], height[endIndex]))
            if (height[startIndex] < height[endIndex]) {
                startIndex++
            } else {
                endIndex--
            }
        }

        return square
    }
}