package array

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/problems/two-sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]



Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

 *
 * */

fun main(){
    var intArray = IntArray(4)
    intArray[0] = 2
    intArray[1] = 7
    intArray[2] = 11
    intArray[3] = 15
    twoSum(intArray, 17).forEach { print("$it ") }
}

// O(n^2)
fun twoSum(nums: IntArray, target: Int): IntArray {
    var solution = IntArray(2)
    var index = 0
    mainLoop@ while(index<nums.size){
        for(i in index+1 until nums.size){
            if(nums[index]+nums[i] == target){
                solution[0] = index
                solution[1] = i
                break@mainLoop
            }
        }
        index++
    }
    return solution
}