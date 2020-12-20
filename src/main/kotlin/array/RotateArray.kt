package array

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]



Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


 *
 * */

fun main(){
    var arr = arrayOf(1,2,3,4,5,6,7).toIntArray()
    rotate(arr, 8)
    arr.forEach { print("$it ") }
}

// O(n) but space complexity is also o(n)
fun rotate(nums: IntArray, k: Int): Unit {
    var size = nums.size
    var step = k % size
    var tempArr = IntArray(step)
    var index = 0
    for(i in size - step until nums.size) tempArr[index++] = nums[i]
    index = size-1
    for(i in size - step -1 downTo 0) nums[index--] = nums[i]
    for(i in tempArr.indices) nums[i] = tempArr[i]
}