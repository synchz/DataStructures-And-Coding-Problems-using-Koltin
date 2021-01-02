package genericproblems

import kotlin.math.ceil

fun main(){
    val a1 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    val a2 =
        arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16))
    rotate(a1,3).forEach {
        it.forEach { r -> print("$r ") }
        println("") }
}
fun rotate(a: Array<IntArray>, n: Int): Array<IntArray> {
    val rotated = Array(n) { IntArray(n) }
    var steps = if(n%2 ==0) n/2 else (n/2) + 1
    for(row in 0 until n){
        for(col in 0 until n){
            a[row][col].also {
                rotated[col][n - row - 1] = a[row][col]
            }
        }
    }
    return rotated
}

fun rotateInPlace(a: Array<IntArray>, n: Int): Array<IntArray> {
    for(i in 0 until n/2){
        for(j in 0 until ceil(n/2.0).toInt()){
            rotateArray(a, n, Pair(i,j), Pair(i,j))
        }
    }

    return a
}

fun rotateArray(a: Array<IntArray>, size :Int, tempPos: Pair<Int, Int>, firstPos: Pair<Int, Int>){
    var t = Pair(tempPos.second, size - tempPos.first - 1)

}
// [[7, 4, 1],
//  [8, 5, 2],
//  [9, 6, 3]]