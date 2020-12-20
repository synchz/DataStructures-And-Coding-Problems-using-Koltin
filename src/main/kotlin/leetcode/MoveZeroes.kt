package leetcode

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 *
 * */

fun main(){
    var intArray = arrayOf(1).toIntArray()
    moveZeroes(intArray)
    intArray.forEach { print("$it ") }
}

//O(n)
fun moveZeroes(nums: IntArray): Unit {
    var lastNonZeroFoundAt = 0
    for(i in nums.indices)
        if(nums[i] !=0 ) nums[i] = nums[lastNonZeroFoundAt].also { nums[lastNonZeroFoundAt++] = nums[i] }
}

// Complexity is O(n^2)
fun `moveZeroesO(n^2)`(nums: IntArray): Unit {
    var detected = 0
    var pos = 0
    while (pos < nums.size - detected) {
        if (nums[pos] == 0) {
            for (j in pos + 1 until nums.size - detected) {
                nums[j - 1] = nums[j]
            }
            nums[nums.size - detected - 1] = 0
            detected++
        } else pos++
    }
}