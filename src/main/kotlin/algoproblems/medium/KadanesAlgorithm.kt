package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Kadane's Algorithm
 *
 * */

//Time complexity O(n)
//Space Complexity O(1)
fun kadanesAlgorithm(array: List<Int>): Int {
    var maxSum = Int.MIN_VALUE
    var currentSum = 0
    for(i in  array){
        currentSum+=i
        if(currentSum < i) currentSum = i
        maxSum = Math.max(currentSum, maxSum)
    }
    return maxSum
}

