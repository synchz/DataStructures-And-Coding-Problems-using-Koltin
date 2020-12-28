package leetcode
/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * */
class IsValidBst {

    fun main() {
        println("is valid bst")
    }

    private var prevNodeValue: Int? = null
    fun isValidBST(root: TreeNode?): Boolean {
        return inOrderTraversal(root)
    }

    private fun inOrderTraversalIterative(root: TreeNode?): Boolean {
        if(null == root) return true
        while(true){

        }
    }

    private fun inOrderTraversal(node: TreeNode?): Boolean {
        if (node == null) return true
        node.left?.let {
            if (!inOrderTraversal(it)) return false
        }
        prevNodeValue?.let {
            if (it >= node.`val`) return false
        }
        prevNodeValue = node.`val`
        return inOrderTraversal(node.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}