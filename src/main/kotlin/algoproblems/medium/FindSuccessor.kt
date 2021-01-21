package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Find Successor
 *
 * */
class FindSuccessor {
    open class BinaryTree(value: Int) {
        var value = value
        var left: BinaryTree? = null
        var right: BinaryTree? = null
        var parent: BinaryTree? = null
    }

//Time Complexity = O(h)  h is height of tree
//Space Complexity = O(1)
fun findSuccessor(tree: BinaryTree, node: BinaryTree): BinaryTree? {
        when {
            node.right != null -> {
                var n = node.right
                while (true) {
                    if (n?.left == null) return n
                    n = n?.left
                }
            }
            (node.parent == null || node.parent!!.right == node) -> {
                return node.parent?.parent
            }
            else -> {
                return node.parent
            }
        }
        return null
    }
}