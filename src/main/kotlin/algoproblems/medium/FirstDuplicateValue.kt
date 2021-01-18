package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * First Duplicate Value
 *
 * */

// Time Complexity = O(N)
// Space Complexity = O(1)
fun firstDuplicateValue(array: MutableList<Int>): Int {
    for(a in array){
        var t = Math.abs(a)
        if(array[t-1]<0) return t
        array[t-1] *= -1
    }
    return -1
}

// Time Complexity = O(N)
// Space Complexity = O(N)
fun firstDuplicateValueUsingSpace(array: MutableList<Int>): Int {
    var t = MutableList(array.size){0}
    for(a in array){
        t[a-1]+=1
        if(t[a-1]>1) return a
    }
    return -1
}