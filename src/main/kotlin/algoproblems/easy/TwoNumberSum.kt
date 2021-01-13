package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Two Number Sum
 *
 * */

//Time O(N Log N)
//Space O(1)
fun `twoNumberSumNLogN`(array: MutableList<Int>, targetSum: Int): List<Int> {
    var sol = ArrayList<Int>()
    if(array.size<2) return sol
    array.sort()
    var i = 0
    var j = array.size-1
    while(i<j){
        when {
            array[i]+array[j] > targetSum -> j--
            array[i] + array[j] < targetSum -> i++
            else -> {
                sol.add(array[i++])
                sol.add(array[j--])
            }
        }
    }
    return sol
}

//Time O(N)
//Space O(N)
fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    var sol = ArrayList<Int>()
    if(array.size<2) return sol
    var set = HashSet<Int>()
    for(i in array){
        var j = targetSum-i
        if(set.contains(j)) sol.apply {
            add(i)
            add(j)
        }
        set.add(i)
    }
    return sol
}