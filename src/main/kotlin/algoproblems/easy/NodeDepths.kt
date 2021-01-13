package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Node Depths
 *
 * */

//Time Complexity O(n)
//Space Complexity O(n)
fun nodeDepths(root: BinaryTree?, depth:Int=0): Int {
    if(root == null) return 0
    return depth + nodeDepths(root.left, depth+1)+ nodeDepths(root.right, depth+1)
}
