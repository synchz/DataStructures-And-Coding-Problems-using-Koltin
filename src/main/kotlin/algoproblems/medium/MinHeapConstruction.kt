package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Min Heap Construction
 *
 * */

open class MinHeap(array: MutableList<Int>) {
    val heap = this.buildHeap(array)

    fun findChildNodes(parentIdx:Int):Pair<Int, Int>{
        var first = (2 * parentIdx) + 1
        var second = (2 * parentIdx) + 2
        return Pair(first, second)
    }

    fun findParentNode(childIdx:Int):Int{
        return (childIdx-1)/2
    }


    //Time complexity O(n)
    //Space Complexity O(1)
    fun buildHeap(array: MutableList<Int>): MutableList<Int> {
        var parent = findParentNode(array.size-1)
        for(i in parent downTo 0){
            siftDown(i, array.size-1, array)
        }
        return array
    }


    //Time complexity O(log n)
    //Space Complexity O(1)
    fun siftDown(currentIdx: Int, endIdx: Int, heap: MutableList<Int>) {
        var current = currentIdx
        var childPair = findChildNodes(currentIdx)
        while(true){
            if(childPair.first > endIdx) break
            var child = if(childPair.second > endIdx|| heap[childPair.first] < heap[childPair.second]) childPair.first
            else childPair.second
            if(heap[child]<heap[current]){
                heap[child] = heap[current].also{
                    heap[current] = heap[child]
                }
                current = child
                childPair = findChildNodes(current)
            }else break
        }
    }


    //Time complexity O(log n)
    //Space Complexity O(1)
    fun siftUp(currentIdx: Int, heap: MutableList<Int>) {
        var parentIdx = findParentNode(currentIdx)
        var current = currentIdx
        if(parentIdx<0) return
        while(current > 0 && heap[current]<heap[parentIdx]){
            heap[parentIdx] = heap[current].also{
                heap[current] = heap[parentIdx]
            }
            current = parentIdx
            parentIdx = findParentNode(current)
        }
    }

//    O(1)
    fun peek(): Int? {
        return heap[0]
    }

    //Time complexity O(log n)
    //Space Complexity O(1)
    fun remove(): Int? {
        var node = this.heap[0]
        this.heap[0] = this.heap[this.heap.size-1]
        heap.removeAt(heap.size-1)
        siftDown(0, this.heap.size-1, this.heap)
        return node
    }

    //Time complexity O(log n)
    //Space Complexity O(1)
    fun insert(value: Int) {
        this.heap.add(value)
        siftUp(this.heap.size-1, this.heap)
    }
}
