package leetcode

fun main() {
    println("Fibonacci\n")
    for(i in 0..43){
        print("${fibonacciIterative(i)} ")
    }
    println()
    for(i in 0..43){
        print("${fibonacciReccursive(i)} ")
    }
    println()
    for(i in 0..43){
        print("${fibonacciWitMemoization(i)} ")
    }
}

fun fibonacciIterative(value: Int): Int {
    return when(value) {
        0 -> 0
        1,2 -> 1
        else -> {
            var prev = 1
            var next = 1
            var count = value - 2
            while (count > 0) {
                next += prev.also { prev = next }
                count--
            }
            next
        }
    }

}

fun fibonacciReccursive(value: Int):Int {
    return when(value){
        0 -> 0
        1,2 -> 1
        else->{
            fibonacciReccursive(value-1) + fibonacciReccursive(value-2)
        }
    }
}

fun fibonacciWitMemoization(value: Int):Int{
    var fibArrayList = arrayListOf(0, 1, 1)
    fun calculateFibonnaciSequesnce(value: Int):Int {
        return if (value < fibArrayList.size) fibArrayList[value]
        else
            (calculateFibonnaciSequesnce(value - 1) + calculateFibonnaciSequesnce(value - 2)).let {
                fibArrayList.add(it)
                it
            }
    }
    return calculateFibonnaciSequesnce(value)
}