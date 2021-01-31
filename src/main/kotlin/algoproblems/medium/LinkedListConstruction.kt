package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Linked List Construction
 *
 * */

class Node(value: Int) {
    val value = value
    var prev: Node? = null
    var next: Node? = null
}

class DoublyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null

//    O(1)
    fun setHead(node: Node) {
        if(head == null){
            head = node
            tail = node
            return
        }
        insertBefore(head!!, node)
    }

//        O(1)
    fun setTail(node: Node) {
        if(tail == null){
            setHead(node)
            return
        }
        insertAfter(tail!!, node)
    }

    //    O(1)
    fun insertBefore(node: Node, nodeToInsert: Node) {
        if(head == nodeToInsert && tail == nodeToInsert) return
        remove(nodeToInsert)
        nodeToInsert.prev = node.prev
        nodeToInsert.next = node
        if(node.prev==null) head = nodeToInsert
        else node.prev?.next = nodeToInsert
        node.prev = nodeToInsert
    }
    //    O(1)
    fun insertAfter(node: Node, nodeToInsert: Node) {
        if(head == nodeToInsert && tail == nodeToInsert) return
        remove(nodeToInsert)
        nodeToInsert.prev = node
        nodeToInsert.next = node.next
        if(node.next == null) tail = nodeToInsert
        else node.next?.prev = nodeToInsert
        node.next = nodeToInsert
    }
    //    O(p)
    fun insertAtPosition(position: Int, nodeToInsert: Node) {
        var node  = head
        var pos = 1
        while(node!=null && pos++ < position){
            node = node?.next
        }
        if(node == null) setTail(nodeToInsert)
        else insertBefore(node!!, nodeToInsert)
    }
    //    O(1n)
    fun removeNodesWithValue(value: Int) {
        var node  = head
        while(node!=null){
            var nxt = node?.next
            if(node!!.value == value) remove(node!!)
            node = nxt
        }
    }
    //    O(1)
    fun remove(node: Node) {
        if(node == head) head = node.next
        if(node == tail) tail = node.prev
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.prev = null
        node.next = null
    }
    //    O(n)
    fun containsNodeWithValue(value: Int): Boolean {
        var node  = head
        while(node!=null){
            if(node!!.value == value) return true
            node = node?.next
        }
        return false
    }

    fun getHead(): Node? { return this.head }

    fun getTail(): Node? { return this.tail }
}
