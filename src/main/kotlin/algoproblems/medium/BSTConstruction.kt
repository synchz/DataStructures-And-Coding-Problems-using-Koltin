package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * BST Construction
 *
 * */

//Avg Time Complexity : O(log(N)), Worst Time Complexity : O(N)
//Space Complexity : O(1)
open class BSTConstruction(value: Int) {
    var value = value
    var left: BSTConstruction? = null
    var right: BSTConstruction? = null

    fun insert(value: Int): BSTConstruction {
        var n: BSTConstruction? = this
        var prev: BSTConstruction = this
        while(true){
            when{
                null == n->{
                    if(value<prev.value) prev.left = BSTConstruction(value)
                    else prev.right = BSTConstruction(value)
                    return this
                }
                value<n.value -> n = n.left.also{prev = n!!}
                else -> n = n.right.also{prev = n!!}
            }
        }
        return this
    }

    fun contains(value: Int): Boolean {
        var n:BSTConstruction? = this
        while(true){
            when{
                null == n->return false
                value<n.value -> n = n.left
                value>n.value -> n = n.right
                value == n.value -> return true
            }
        }
        return false
    }

    fun remove(value: Int, parentNode:BSTConstruction? = null): BSTConstruction {
        var current:BSTConstruction? = this
        var parent:BSTConstruction? = parentNode
        while(current!=null){
            when{
                value < current.value -> {
                    parent = current
                    current = current.left
                }
                value > current.value -> {
                    parent = current
                    current = current.right
                }
                else->{
                    if(current.left !=null && current.right!=null){
                        current.right!!.findMin().let{ node->
                            current.value = node.value
                            node.remove(node.value, node)
                            current.right!!.remove(current.value, current)
                        }
                    }else if(parent == null){
                        if(current.left != null){
                            current.value = current.left!!.value
                            current.right = current.left!!.right
                            current.left = current.left!!.left
                        }else if(current.right != null){
                                current.value = current.right!!.value
                                current.left = current.right!!.left
                                current.right = current.right!!.right
                        }
                    }
                    else if(current.left!=null){
                        if(parent.left == current){
                            parent.left = current.left
                        }else{
                            parent.right = current.right
                        }
                    }else{
                        if(parent.left == current){
                            parent.left = current.right
                        }else{
                            parent.right = current.right
                        }
                    }
                    break
                }
            }
        }
        return this
    }

    fun findMin():BSTConstruction{
        var current:BSTConstruction = this
        while(true){
            if(current.left == null) return current
            else current = current.left!!
        }
    }
}
