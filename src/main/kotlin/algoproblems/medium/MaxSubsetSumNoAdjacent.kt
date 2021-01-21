package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Max Subset Sum No Adjacent
 *
 * */

//Time complexity = O(N)
//Space complexity = O(1)
fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    if(array.isEmpty()) return 0
    if(array.size==1) return array[0]
    var i = array[0]
    var j = Math.max(i, array[1])
    for(a in 2 until array.size){
        var max = Math.max(j, i+array[a])
        i = j
        j = max
    }
    return j
}