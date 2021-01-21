package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Min Height BST
 *
 * */

fun BST.insert(value: Int) {
    if (value < this.value) {
        if (this.left == null) {
            this.left = BST(value)
        } else {
            this.left!!.insert(value)
        }
    } else {
        if (this.right == null) {
            this.right = BST(value)
        } else {
            this.right!!.insert(value)
        }
    }
}

fun main(){
    minHeightBst(listOf(1, 2, 5, 7, 10, 13, 14, 15, 22))
}

//Time Complexity : O(N LOG(N)) -> log n for insertion of elements
//Space Complexity : O(N)
fun minHeightBstNaive(array: List<Int>): BST {
    var bst:BST? = null
    fun addNodesToBST(left:Int, right:Int){
        if(right<left) return
        var i = (right+left)/2
        if(bst == null) bst = BST(array[i])
        else bst?.insert(array[i])
        addNodesToBST(left, i-1)
        addNodesToBST(i+1, right)
    }
    addNodesToBST(0, array.size-1)
    return bst!!
}

//Time Complexity : O(N)
//Space Complexity : O(N)
fun minHeightBstReusingRoot(array: List<Int>): BST {
    fun addNodesToBST(left:Int, right:Int, bst: BST?):BST?{
        var t = bst
        if(right<left) return null
        var i = (right+left)/2
        t = if(t == null) {
            BST(array[i])
        } else {
            t.insert(array[i])
            if(t.left?.value == array[i]) t.left
            else t.right
        }
        addNodesToBST(left, i-1, t)
        addNodesToBST(i+1, right, t)
        return t
    }

    return addNodesToBST(0, array.size-1, null)!!
}


//Time Complexity : O(N)
//Space Complexity : O(N)
fun minHeightBst(array: List<Int>): BST {
    fun addNodesToBST(left:Int, right:Int):BST?{
        if(right<left) return null
        var mid = (right+left)/2
        return BST(array[mid]).apply {
            this.left = addNodesToBST(left, mid-1)
            this.right = addNodesToBST(mid+1, right)
        }
    }
    return addNodesToBST(0, array.size-1)!!
}