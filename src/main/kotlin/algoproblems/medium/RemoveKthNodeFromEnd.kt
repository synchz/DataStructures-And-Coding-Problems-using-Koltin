package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Remove Kth Node From End
 *
 * */

//Time complexity O(n)
//Space Complexity O(1)
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeKthNodeFromEnd(head: LinkedList, k: Int) {
    var firstNode:LinkedList? = head
    var secondNode:LinkedList? = head
    var c = 1
    while(secondNode?.next!=null){
        if(c++>k) firstNode = firstNode?.next
        secondNode = secondNode?.next
    }
    if(c == k)
        firstNode?.value = firstNode?.next?.value?:-1
    firstNode?.next = firstNode?.next?.next

}


