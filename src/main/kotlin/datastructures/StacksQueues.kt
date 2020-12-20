package datastructures

fun main(){
    println("Stacks")
    var stack = Stack<String>()
    stack.push("Apple")
    stack.push("Boy")
    stack.push("Cat")
    println("size ${stack.getSize()}")
    println("pop ${stack.pop()}")
    println("size ${stack.getSize()}")
    println("peek ${stack.peek()}")
    println("size ${stack.getSize()}")
    println("pop ${stack.pop()}")
    println("pop ${stack.pop()}")
    println("pop ${stack.pop()}")
    var queue = Queue<String>()
    queue.enqueue("Apple")
    queue.enqueue("Boy")
    queue.enqueue("Cat")
    println("size ${queue.getSize()}")
    println("dequeue ${queue.dequeue()}")
    println("size ${queue.getSize()}")
    println("peek ${queue.peek()}")
    println("size ${queue.getSize()}")
    println("dequeue ${queue.dequeue()}")
    println("dequeue ${queue.dequeue()}")
    println("dequeue ${queue.dequeue()}")
}

class Stack<T>{

    private var arrayList = ArrayList<T>()

    fun getSize() = arrayList.size

    fun push(value: T){
        arrayList.add(value)
    }

    fun pop():T?{
        if(arrayList.size-1 <0) return null
        var element = arrayList[arrayList.size-1]
        arrayList.removeAt(arrayList.size-1)
        return element
    }

    fun peek():T?{
        if(arrayList.size-1 <0) return null
        return arrayList[arrayList.size-1]
    }
}

class Queue<T>{
    private var arrayList = ArrayList<T>()

    fun getSize() = arrayList.size

    fun enqueue(value: T){
        arrayList.add(value)
    }

    fun dequeue():T?{
        if(arrayList.size == 0) return null
        var element = arrayList[0]
        arrayList.removeAt(0)
        return element
    }

    fun peek():T?{
        if(arrayList.size == 0) return null
        return arrayList[0]
    }
}