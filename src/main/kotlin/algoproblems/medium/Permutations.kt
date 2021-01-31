package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Permutations
 *
 * */

// Time complexity = O(n! * n^2)
// Space complexity = O(n! * n)
fun getPermutations(array: List<Int>): List<List<Int>> {
    var sol = ArrayList<List<Int>>()
    if(array.isEmpty()) return sol
    fun generateSequences(list:ArrayList<Int>, perm: ArrayList<Int>){
        if(list.isEmpty()){
            sol.add(perm)
            return
        }
        for(i in list){
            var newList = ArrayList<Int>(list)
            newList.remove(i)
            var newPerm = ArrayList<Int>(perm)
            newPerm.add(i)
            generateSequences(newList, newPerm)
        }
    }
    generateSequences(ArrayList(array), ArrayList<Int>())
    return sol
}


