package sorting

fun main(){
    println("Quick Sort")
    var arr = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    arr = quickSort(arr)
    arr.forEach { print("$it ") }
}

fun quickSort(array: Array<Int>):Array<Int>{
    if(array.size<=1) return array
    var pivot = array.size-1
    var index = 0
    while(index != pivot){
        if(array[index]> array[pivot]){
            swapArrayElements(array, index, pivot-1)
            swapArrayElements(array, pivot-1, pivot)
            pivot--
        }else
            index++
    }
    return quickSort(array.sliceArray(0 until pivot)) + array[pivot] + quickSort(array.sliceArray(pivot+1 until array.size))
}

fun swapArrayElements(array: Array<Int>, pos1:Int, pos2: Int){
    var temp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = temp
}