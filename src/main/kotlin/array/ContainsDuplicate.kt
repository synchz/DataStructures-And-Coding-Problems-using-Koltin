package array

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true


 *
 * */

fun main(){
    var arr = arrayOf(1,2,3,1).toIntArray()
    println(containsDuplicate(arr))
}


// O(n)
fun `containsDuplicate O(n)`(nums: IntArray): Boolean {
    var numsHashSet = HashSet<Int>()
    for(n in nums){
        if(numsHashSet.contains(n)) return true
        numsHashSet.add(n)
    }
    return false
}

// O(n Log n)
fun containsDuplicate(nums: IntArray): Boolean {
    nums.sort()
    var t : Int? = null
    for(n in nums){
        t?.let { if(n==t) return true}
        t = n
    }
    return false
}

