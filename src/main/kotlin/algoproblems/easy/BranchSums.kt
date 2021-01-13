package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Branch Sums
 *
 * */

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

// Time Complexity = O(n)
//Space Complexity = O(n)
fun branchSums(root: BinaryTree): List<Int> {
    var sol = ArrayList<Int>()
    fun dfs(node:BinaryTree, prevSum:Int){
        node?.let{ n->
            n.value+=prevSum
            n.left?.let{
                dfs(it, n.value)
            }
            n.right?.let{
                dfs(it, n.value)
            }
            if(null == n.left && null == n.right) sol.add(n.value)
        }
    }
    dfs(root, 0)
    return sol
}