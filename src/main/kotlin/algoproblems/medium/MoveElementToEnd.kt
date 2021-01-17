package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Move Element To End
 *
 * */

//Time Complexity = O(n)
//Space Complexity = O(1)
fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    var i = 0
    var j = array.size-1
    while(i<j){
        when (toMove) {
            array[j] -> j--
            array[i] -> {
                array[i] = array[j].also{array[j]=array[i]}
                i++
            }
            else -> i++
        }
    }
    return array
}
