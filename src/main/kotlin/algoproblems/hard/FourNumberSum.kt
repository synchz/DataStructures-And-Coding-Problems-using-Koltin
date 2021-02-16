package algoproblems.hard

//Time O(N^2) Worst O(N^3)
//Space O(N^2)
fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    val sol = ArrayList<List<Int>>()
    if(array.size<4) return sol
    val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()
    fun checkIfPairExist(a1:Int, a2:Int){
        val sumToFind = targetSum - (a1 + a2)
        if(map.contains(sumToFind)){
            for(i in map[sumToFind]!!){
                sol.add(listOf(i.first, i.second, a1, a2))
            }
        }
    }
    for(i in array.indices){
        for(j in i+1 until array.size){
            checkIfPairExist(array[i], array[j])
        }
        for(k in 0 until i){
            val s = array[i] + array[k]
            val list =  map[s] ?: ArrayList<Pair<Int, Int>>()
            list.add(Pair(array[i], array[k]))
            map[s] = list
        }
    }
    return sol
}