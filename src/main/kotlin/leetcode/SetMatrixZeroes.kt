package leetcode

fun main() {
    var m1 = arrayOf(arrayOf(1, 1, 1).toIntArray(), arrayOf(1, 0, 1).toIntArray(), arrayOf(1, 1, 1).toIntArray())
    var m2 =
        arrayOf(arrayOf(1,0).toIntArray())
    var m3 =
        arrayOf(arrayOf(0, 1, 2, 0).toIntArray(), arrayOf(3, 4, 5, 2).toIntArray(), arrayOf(1, 3, 1, 5).toIntArray())
    println("Before")
    printArrOfArr(m1)
    setZeroes(m1)
    println("After")
    printArrOfArr(m1)
    println("Before")
    printArrOfArr(m2)
    println("After")
    setZeroes(m2)
    printArrOfArr(m2)
}

fun printArrOfArr(matrix: Array<IntArray>){
    matrix.forEach { arr->
        arr.forEach { print("$it ") }
        println()
    }
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    var isFirstRowZero = false
    var isFirstColumnZero = false
    for(col in matrix[0])
        if(col == 0) {
            isFirstRowZero = true
            break
        }
    for(row in matrix)
        if(row[0]==0) {
            isFirstColumnZero = true
            break
        }
    for (row in 1 until matrix.size)
        for (col in 1 until matrix[row].size)
            if (matrix[row][col] == 0){
                matrix[row][0]  = 0
                matrix[0][col]  = 0
            }
    for(col in 1 until matrix[0].size) if(matrix[0][col] == 0) for (row in 1 until matrix.size) matrix[row][col] = 0

    for(row in 1 until matrix.size) if(matrix[row][0] == 0) for(col in 1 until matrix[row].size) matrix[row][col] = 0

    if(isFirstColumnZero) for (element in matrix) element[0] = 0
    if(isFirstRowZero) for(col in matrix[0].indices) matrix[0][col] = 0


}