package ds

import javax.xml.soap.Node

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
    println(tree.root.toString())
}

class BST(value: Int){

    class Node(value: Int){
        var left : Node? = null
        var right : Node? = null
        var value : Int = value

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

    fun search(value: Int): Node? {
        var node:Node? = null
        var currentNode = root
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
                    currentNode =  it
                }
            }
            else{
                if(null == currentNode.right){
                    node = null
                    break
                }
                currentNode.right?.let {
                    currentNode =  it
                }
            }
        }
        return node
    }

}