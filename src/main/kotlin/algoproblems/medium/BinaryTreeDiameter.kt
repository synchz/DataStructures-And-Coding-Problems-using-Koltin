package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Binary Tree Diameter
 *
 * */

fun main(){
    val root = BinaryTree(1)
    root.left = BinaryTree(3)
    root.left!!.left = BinaryTree(7)
    root.left!!.left!!.left = BinaryTree(8)
    root.left!!.left!!.left!!.left = BinaryTree(9)
    root.left!!.right = BinaryTree(4)
    root.left!!.right!!.right = BinaryTree(5)
    root.left!!.right!!.right!!.right = BinaryTree(6)
    root.right = BinaryTree(2)
    val expected = 6
    var output = binaryTreeDiameter(root)
}

// Time Complexity = O(N)
// Space Complexity = O(d) -> depth of tree
fun binaryTreeDiameter(tree: BinaryTree?): Int {
    var max = 0
    fun dfs(t: BinaryTree?):Int{
        if(null == t) return 0
        var current = 1
        var l = dfs(t?.left)
        var r = dfs(t?.right)
        if(l+r > max) max = l+r
        return Math.max(l, r) + current
    }
    dfs(tree)
    return max
}

