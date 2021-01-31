package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Min Number Of Coins For Change
 *
 * */

fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    if(denoms.isEmpty()) return -1
    var arr = IntArray(n+1){Int.MAX_VALUE}
    arr[0] = 0
    for(d in denoms){
        for(i in d until arr.size){
            var c = if(arr[i-d] != Int.MAX_VALUE) arr[i-d] + 1 else Int.MAX_VALUE
            arr[i] = Math.min(c, arr[i])
        }
    }
    return if(arr[n]!=Int.MAX_VALUE) arr[n] else -1
}
