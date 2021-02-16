package leetcode

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * */

fun main() {
    var l = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    reverseList(l)
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseList(head: ListNode?): ListNode? {
    head?.let{
        var node: ListNode? = head
        var prev: ListNode? = null
        while(null != node){
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }
    }
    return head
}

