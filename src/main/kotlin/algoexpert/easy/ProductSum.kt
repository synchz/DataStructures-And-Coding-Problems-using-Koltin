package algoexpert.easy

/**
 *
 * @author Prikshit
 *
 * https://www.algoexpert.io/questions/Product%20Sum
 *
 * */

//Time complexity O(n)
//Space Complexity O(d) depth of array
fun productSum(array: List<*>, depth:Int = 1): Int {
    var sum = 0
    for(element in array){
        sum += if(element is Int) (element * depth)
        else productSum(element as List<*>, depth+1) * depth
    }
    return sum
}