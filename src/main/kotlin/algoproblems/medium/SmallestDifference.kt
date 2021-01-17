package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Smallest Difference
 *
 * */

//Time Complexity = O(n log n + m log m)
//Space Complexity = O(1)
fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    arrayOne.sort()
    arrayTwo.sort()
    var list = listOf<Int>()
    var min = Int.MAX_VALUE
    var cMin = Int.MAX_VALUE
    var i = 0
    var j = 0
    while(i<arrayOne.size && j<arrayTwo.size){
        var aI = arrayOne[i]
        var aJ = arrayTwo[j]
        when{
            aI<aJ -> {
                cMin = aJ-aI
                i++
            }
            aI>aJ -> {
                cMin = aI-aJ
                j++
            }
            else->{
                return listOf(aI, aJ)
            }
        }
        if(cMin<min) {
            min = cMin
            list = listOf(aI, aJ)
        }
    }
    return list
}
