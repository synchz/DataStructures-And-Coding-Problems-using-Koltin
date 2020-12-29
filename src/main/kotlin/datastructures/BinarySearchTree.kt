package datastructures

fun main() {
    println("BST")
    var tree = BST(99)
    tree.insert(30)
    tree.insert(110)
    tree.insert(5)
    tree.insert(40)
    tree.insert(100)
    tree.insert(200)
    println(tree.root.toString())
    var node = tree.search(110)
    println(node.toString())
    println("BFS")
    tree.bfs().forEach { print("$it ") }
    println("\nTREE")
    tree.remove(30)
    println(tree.root.toString())

    var treeN = BST(9)
    treeN.insert(4)
    treeN.insert(20)
    treeN.insert(1)
    treeN.insert(6)
    treeN.insert(15)
    treeN.insert(170)
    println("For tree ${treeN.root}")
    println("Inorder")
    treeN.dfsInOrder().forEach { print("$it ") }
    println("\nPreorder")
    treeN.dfsPreOrder().forEach { print("$it ") }
    println("\nPostorder")
    treeN.dfsPostOrder().forEach { print("$it ") }
}

class BST(value: Int) {

    data class NodeWithParent(var node: Node, var parentNode: Node?, var isLeftChild: Boolean?) {
        fun setNodesChild(node: Node?) {
            when (isLeftChild) {
                true -> parentNode?.left = node
                else -> parentNode?.right = node
            }
        }
    }

    class Node(value: Int) {
        var left: Node? = null
        var right: Node? = null
        var value: Int = value

        //        Returns a JSON
        override fun toString(): String {
            return "{\"left\":$left,\"value\":\"$value\",\"right\":$right}"
        }
    }

    var root: Node = Node(value)

    fun insert(value: Int) {
        var currentNode = root
        while (true) {
            if (value < currentNode.value) {
                if (null == currentNode.left) {
                    currentNode.left = Node(value)
                    break
                }
                currentNode.left?.let { currentNode = it }
            } else {
                if (null == currentNode.right) {
                    currentNode.right = Node(value)
                    break
                }
                currentNode.right?.let { currentNode = it }
            }
        }
    }

    fun search(value: Int): NodeWithParent? {
        var node: Node? = null
        var currentNode = root
        var parentNode: Node? = null
        var isLeftChild: Boolean? = null
        while (true) {
            if (value == currentNode.value) {
                node = currentNode
                break
            } else if (value < currentNode.value) {
                if (null == currentNode.left) {
                    node = null
                    break
                }
                currentNode.left?.let {
                    parentNode = currentNode
                    currentNode = it
                    isLeftChild = true
                }
            } else {
                if (null == currentNode.right) {
                    node = null
                    break
                }
                currentNode.right?.let {
                    parentNode = currentNode
                    currentNode = it
                    isLeftChild = false
                }
            }
        }
        node?.let {
            return NodeWithParent(node, parentNode, isLeftChild)
        }
        return null
    }

    fun remove(value: Int): BST? {
        search(value)?.let {
            if (null == it.parentNode) {
                this.root = it.node
            } else if (it.node.left != null && it.node.right != null) {
                var prevNode: Node? = null
                var currentNode: Node? = it.node.right

                while (currentNode != null) {
                    if (currentNode.left == null) {
                        it.node?.value = currentNode.value
                        if (prevNode == null) {
                            it.node.right = currentNode?.right
                        }
                        prevNode?.let {
                            prevNode?.left = currentNode?.right
                        }
                    }
                    prevNode = currentNode
                    currentNode = currentNode.left
                }
            } else if (it.node.left == null) {
                it.setNodesChild(it.node.right)
            } else if (it.node.right == null) {
                it.setNodesChild(it.node.left)
            } else {
                it.setNodesChild(null)
            }
            return this
        }
        return null
    }

    fun bfs(): ArrayList<Int> {
        var list = ArrayList<Int>()
        var queue = Queue<Node>()
        queue.enqueue(root)
        while (queue.getSize() > 0) {
            queue.dequeue()?.let { currentNode ->
                list.add(currentNode.value)
                currentNode.left?.let {
                    queue.enqueue(it)
                }
                currentNode.right?.let {
                    queue.enqueue(it)
                }
            }
        }
        return list
    }

    fun dfsInOrder(): ArrayList<Int> {
        return ArrayList<Int>().let { traversedList ->
            fun traverseInOrder(currentNode: Node) {
                currentNode.left?.let {
                    traverseInOrder(it)
                }
                traversedList.add(currentNode.value)
                currentNode.right?.let {
                    traverseInOrder(it)
                }
                return
            }
            traverseInOrder(root)
            traversedList
        }
    }

    fun dfsPostOrder(): ArrayList<Int> {
        return ArrayList<Int>().let { traversedList->
             fun traversePostOrder(currentNode: Node) {
                currentNode.left?.let {
                    traversePostOrder(it)
                }
                currentNode.right?.let {
                    traversePostOrder(it)
                }
                traversedList.add(currentNode.value)
                return
            }
            traversePostOrder(root)
            traversedList
        }
    }

    fun dfsPreOrder(): ArrayList<Int> {
        return ArrayList<Int>().let {traversedList->
            fun traversePreOrder(currentNode: Node,) {
                traversedList.add(currentNode.value)
                currentNode.left?.let {
                    traversePreOrder(it)
                }
                currentNode.right?.let {
                    traversePreOrder(it)
                }
                return
            }
            traversePreOrder(root)
            traversedList
        }
    }

}

