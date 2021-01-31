package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Powerset
 *
 * */

//Time complexity O(n*2^n)
//Space Complexity O(n*2^n)
fun powerset(array: List<Int>): List<List<Int>> {
    var sol = ArrayList<List<Int>>()
    fun genPerm(index:Int, count:Int, perm:ArrayList<Int>){
        if(count == 0){
            sol.add(perm)
            return
        }
        for(i in index until array.size){
            var newPerm = ArrayList<Int>(perm)
            newPerm.add(array[i])
            genPerm(i+1, count-1, newPerm)
        }
    }
    for(i in 0..array.size){
        genPerm(0, i, ArrayList<Int>())
    }
    return sol
}


