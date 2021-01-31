package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Populating Next Right Pointers in Each Node
 *
 * */
class PopulatingNextRightPointersinEachNode {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {

        var queue = ArrayList<Node?>()
        root?.let {
            queue.add(it)
            queue.add(null)
        }
        while (queue.isNotEmpty()) {
            var node = queue.removeAt(0)
            if (queue.isNotEmpty()) {
                if (null == node) queue.add(null)
                node?.next = queue[0]
            }
            node?.left?.let { queue.add(it) }
            node?.right?.let { queue.add(it) }
        }
        return root
    }
}

