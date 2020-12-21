package leetcode

fun main(){
    println("Factorial")
    println(factorialIterative(10))
    println(factorialRecursive(10))
}

fun factorialRecursive(value: Int): Int {
    if(value <= 1) return 1
    return value * factorialRecursive(value-1)
}

fun factorialIterative(value: Int): Int {
    var factorial = value
    var solution = 1
    while(factorial>1){
        solution *= factorial--
    }
    return solution
}