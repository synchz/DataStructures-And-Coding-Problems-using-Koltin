package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Task Assignment
 *
 * */

//Time complexity O(n log n) n=k
//Space Complexity O(n) = n=k
fun taskAssignment(k: Int, tasks: MutableList<Int>): List<List<Int>> {
    var actualPos = HashMap<Int, MutableList<Int>>()
    for(i in tasks.indices){
        if(actualPos.contains(tasks[i])){
            actualPos[tasks[i]] = actualPos[tasks[i]]!!.apply {
                add(i)
            }
        }else
            actualPos[tasks[i]] = mutableListOf(i)
    }
    tasks.sort()
    var sol = ArrayList<List<Int>>()
    var i = 0
    var j = tasks.size - 1
    fun getTask(t:Int):Int{
        actualPos[t]?.let { list->
            var pos = list.removeFirst()
            actualPos[t] = list
            return pos
        }
        return -1
    }
    while(i<j){
        sol.add(listOf(getTask(tasks[i++]),getTask(tasks[j--])))
    }
    return sol
}

