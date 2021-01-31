package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Cycle In Graph
 *
 * */

//Time complexity O(v + e) e are edges
//Space Complexity O(v)
fun cycleInGraph(edges: List<List<Int>>): Boolean {
    fun dfs(node : Int, visited:HashSet<Int>):Boolean{
        if(visited.contains(node)) return true
        if(edges[node].isEmpty()) return false
        visited.add(node)
        for(i in edges[node]){
            if(dfs(i, visited)) return true
            else visited.remove(i)
        }
        visited.remove(node)
        return false
    }
    for(i in edges.indices){
        if(dfs(i, HashSet<Int>())) return true
    }
    return false
}


