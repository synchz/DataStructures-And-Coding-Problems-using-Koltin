package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Binary Search
 *
 * */

fun binarySearch(array: List<Int>, target: Int): Int {
    var strt = 0
    var end = array.size-1
    while(strt<=end){
        var ptr = (end+strt)/2
        when {
            array[ptr] == target -> return ptr
            target > array[ptr] -> {
                strt = ptr+1
            }
            else -> {
                end = ptr-1
            }
        }
    }
    return -1
}