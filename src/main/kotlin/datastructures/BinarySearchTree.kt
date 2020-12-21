package datastructures

import com.sun.org.apache.xerces.internal.dom.ParentNode

fun main(){
    println("BST")
    var tree = BST(99)
    tree.insert(30)
    tree.insert(110)
    tree.insert(5)
    tree.insert(40)
    tree.insert(100)
    tree.insert(200)
    var node = tree.search(110)
    println(node.toString())
    println("TREE")
    tree.remove(30)
    println(tree.root.toString())
}

class BST(value: Int){

    data class NodeWithParent(var node:Node, var parentNode:Node?, var isLeftChild:Boolean?){
        fun setNodesChild( node: Node?) {
            when (isLeftChild) {
                true -> parentNode?.left = node
                else -> parentNode?.right = node
            }
        }
    }

    class Node(value: Int){
        var left : Node? = null
        var right : Node? = null
        var value : Int = value

//        Returns a JSON
        override fun toString(): String {
            return "{\"left\":$left,\"value\":\"$value\",\"right\":$right}"
        }
    }

    var root : Node = Node(value)

    fun insert(value: Int){
        var currentNode = root
        while(true){
            if(value < currentNode.value){
                if(null == currentNode.left){
                    currentNode.left = Node(value)
                    break
                }
                currentNode.left?.let { currentNode =  it }
            }else{
                if(null == currentNode.right){
                    currentNode.right = Node(value)
                    break
                }
                currentNode.right?.let { currentNode =  it }
            }
        }
    }

    fun search(value: Int): NodeWithParent? {
        var node:Node? = null
        var currentNode = root
        var parentNode : Node? = null
        var isLeftChild:Boolean? = null
        while(true){
            if(value == currentNode.value){
                node = currentNode
                break
            }else if(value < currentNode.value){
                if(null == currentNode.left){
                    node = null
                    break
                }
                currentNode.left?.let {
                    parentNode = currentNode
                    currentNode =  it
                    isLeftChild = true
                }
            }
            else{
                if(null == currentNode.right){
                    node = null
                    break
                }
                currentNode.right?.let {
                    parentNode = currentNode
                    currentNode =  it
                    isLeftChild = false
                }
            }
        }
        node?.let {
            return NodeWithParent(node, parentNode, isLeftChild)
        }
        return null
    }

    fun remove(value: Int) : BST?{
        search(value)?.let{
            if(null == it.parentNode){
                this.root = it.node
            }else if(it.node.left != null && it.node.right != null){
                var prevNode:Node? = null
                var currentNode: Node? = it.node.right

                while(currentNode!=null){
                    if(currentNode.left == null){
                        it.node?.value = currentNode.value
                        if(prevNode == null){
                            it.node.right = currentNode?.right
                        }
                        prevNode?.let{
                            prevNode?.left = currentNode?.right
                        }
                    }
                    prevNode = currentNode
                    currentNode = currentNode.left
                }
            }else if(it.node.left == null){
                it.setNodesChild(it.node.right)
            }else if(it.node.right == null){
                it.setNodesChild(it.node.left)
            }else{
                it.setNodesChild( null)
            }
            return this
        }
        return null
    }



}