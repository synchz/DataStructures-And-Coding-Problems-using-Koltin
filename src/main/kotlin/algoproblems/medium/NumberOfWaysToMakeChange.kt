package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Number Of Ways To Make Change
 *
 * */

fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    var arr = IntArray(n+1){0}
    arr[0] = 1
    for(d in denoms){
        if(d>n) continue
        for(i in d until arr.size){
            arr[i] += arr[i-d]
        }
    }
    return arr[n]
}
