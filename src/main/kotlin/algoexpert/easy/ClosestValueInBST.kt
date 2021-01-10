package algoexpert.easy

/**
 *
 * @author Prikshit
 *
 * https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
 *
 * */
open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

//Time Complexity - O(log n) worst o(n)
//Space complexity - O(1)
fun findClosestValueInBst(tree: BST, target: Int): Int {
    var closestNode:Int? = null
    var currentNode:BST? = tree
    while(currentNode!=null){
            if(closestNode == null ||
                (Math.abs(target - closestNode) > Math.abs(target - currentNode.value)))
                closestNode = currentNode.value
            currentNode = when{
                currentNode.value == target -> null
                target < currentNode.value  -> currentNode.left
                else -> currentNode.right
            }
    }
    closestNode?.let{
        return it
    }
    return -1
}

//Time Complexity - O(log n) worst O(n)
//Space complexity - O(log n) worst O(n)
fun `findClosestValueInBstWithSpace`(tree: BST, target: Int): Int {
    var closestNode:Int? = null
    fun traverseNode(node:BST?){
        if(node == null) return
        node?.let{ n->
            if(closestNode == null ||
                (Math.abs(target - closestNode!!) > Math.abs(target - n.value)))
                closestNode = n.value
            when{
                n.value == target -> return
                target < n.value  -> traverseNode(node.left)
                else -> traverseNode(n.right)
            }
        }
    }
    traverseNode(tree)
    closestNode?.let{
        return it
    }
    return -1
}
