package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Validate BST
 *
 * */

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun main(){
    val tree = BST(10)
    tree.left = BST(5)
    tree.left!!.left = BST(2)
    tree.left!!.left!!.left = BST(1)
    tree.left!!.right = BST(5)
    tree.right = BST(15)
    tree.right!!.left = BST(13)
    tree.right!!.left!!.right = BST(14)
    tree.right!!.right = BST(22)

    var t = ArrayList<Int>()
    inOrderTraversal(tree, t)
    print("$t ")

    var t1 = ArrayList<Int>()
    val tree1 = BST(10)
    tree1.left = BST(5)
    tree1.right = BST(15)
    tree1.left!!.right = BST(10)
    inOrderTraversal(tree1, t1)
    print("$t1 ")
}

fun inOrderTraversal(tree:BST, traversedArr:ArrayList<Int>){
    tree.left?.let{
        inOrderTraversal(it, traversedArr)
    }
    traversedArr.add(tree.value)
    tree.right?.let{
        inOrderTraversal(it, traversedArr)
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
fun validateBstUsingInOrder(tree: BST): Boolean {
    var t = ArrayList<Int>()
    inOrderTraversal(tree, t)
    if(t.size <2) return true
    for(i in 1 until t.size){
        if(t[i-1]>t[i]) return false
    }
    return true
}

//Time Complexity : O(N)
//Space Complexity : O(d) where d is depth of tree used to maintain backstack trace
fun validateBst(tree: BST): Boolean {
    fun validate(tree:BST?, minValue:Int, maxValue:Int):Boolean{
        if(null == tree) return true
        else if(tree.value<minValue || tree.value>=maxValue) return false
        return validate(tree.left, minValue, tree.value) && validate(tree.right, tree.value, maxValue)
    }
    return validate(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}
