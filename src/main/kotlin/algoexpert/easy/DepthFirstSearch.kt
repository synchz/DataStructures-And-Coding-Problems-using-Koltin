package algoexpert.easy

/**
 *
 * @author Prikshit
 *
 * https://www.algoexpert.io/questions/Depth-first%20Search
 *
 * */

//Time complexity - O(v+e)
//Space Complexity - O(v)
class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()
    var fibCache = arrayListOf(0, 0, 1)
    fun depthFirstSearch(): List<String> {
        var sol = ArrayList<String>()
        fun dfs(node:Node){
            sol.add(node.name)
            for(child in node.children)
                dfs(child)
        }
        dfs(this)
        return sol
    }

}
