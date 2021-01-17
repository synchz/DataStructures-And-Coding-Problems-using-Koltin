package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Three Number Sum
 *
 * */

//Time Complexity = O(n^2 + n Log n)
//Space Complexity = O(n)
fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    var list = ArrayList<List<Int>>()
    if(array.size<3) return list
    array.sort()
    for(i in 0 until array.size-2){
        var strt = i+1
        var end = array.size-1
        while(strt<end){
            var sum = array[strt]+array[end]+array[i]
            when {
                sum == targetSum -> list.add(listOf(array[i], array[strt++], array[end--]))
                sum>targetSum -> end--
                else -> strt++
            }

        }
    }
    return list
}