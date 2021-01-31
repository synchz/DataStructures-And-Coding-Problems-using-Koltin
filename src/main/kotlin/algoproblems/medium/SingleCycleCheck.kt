package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Single Cycle Check
 *
 * */

//Time complexity O(n)
//Space Complexity O(1)
fun hasSingleCycle(arr: MutableList<Int>): Boolean {
    if(arr.size<2) return true
    var total = 1
    var size = arr.size
    var current = arr[0]
    current%=size
    if(current<0) current += size
    while(current!=0){
        total++
        if(arr[current]==0) return false
        current += arr[current].also{arr[current] = 0}
        current%=size
        if(current<0) current += size
    }
    return total == size
}
