package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * BST Traversal
 *
 * */

//Time Complexity : O(N)
//Space Complexity : O(N)
fun inOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    tree.left?.let{
        inOrderTraverse(it, array)
    }
    array.add(tree.value)
    tree.right?.let{
        inOrderTraverse(it, array)
    }
    return array
}

fun preOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    array.add(tree.value)
    tree.left?.let{
        preOrderTraverse(it, array)
    }
    tree.right?.let{
        preOrderTraverse(it, array)
    }
    return array
}

fun postOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    tree.left?.let{
        postOrderTraverse(it, array)
    }
    tree.right?.let{
        postOrderTraverse(it, array)
    }
    array.add(tree.value)
    return array
}
