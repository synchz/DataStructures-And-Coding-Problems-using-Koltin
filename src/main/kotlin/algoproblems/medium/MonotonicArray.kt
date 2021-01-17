package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Monotonic Array
 *
 * */

//Time Complexity = O(n)
//Space Complexity = O(1)
fun isMonotonic(array: List<Int>): Boolean {
    if(array.size<3) return true
    var isIncreasing = 0
    for(i in 1 until array.size){
        if(array[i] > array[i-1] && isIncreasing < 0){
            return false
        }else if(array[i]<array[i-1] && isIncreasing > 0){
            return false
        }else if(isIncreasing == 0) isIncreasing = array[i] - array[i-1]
    }
    return true
}
