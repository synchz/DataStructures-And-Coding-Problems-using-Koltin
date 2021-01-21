package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Invert Binary Tree
 *
 * */

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

// Time Complexity = O(N)
// Space Complexity = O(d) -> depth of tree
fun invertBinaryTree(tree: BinaryTree?) {
    if(tree == null) return
    tree.left = tree.right.also{tree.right = tree.left}
    invertBinaryTree(tree.left)
    invertBinaryTree(tree.right)
}
