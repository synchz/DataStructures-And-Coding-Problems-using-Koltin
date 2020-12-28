package sorting

fun main(){
    println("Merge Sort")
    var arr = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    arr = mergeSort(arr)
    arr.forEach { print("$it ") }
}

fun mergeSort(array: Array<Int>): Array<Int> {
    if(array.size <= 1) return array
    return merge(
        mergeSort(array.sliceArray(0 until (array.size/2))),
        mergeSort(array.sliceArray((array.size/2) until array.size))
    )
}

fun merge(array1: Array<Int>, array2: Array<Int>):Array<Int>{
    var array = Array<Int>(array1.size + array2.size){0}
    var arr1Index = 0
    var arr2Index = 0
    var index = 0
    while(arr1Index<array1.size && arr2Index<array2.size){
        if(array1[arr1Index]< array2[arr2Index]) array[index++] = array1[arr1Index++]
        else array[index++] = array2[arr2Index++]
    }
    if(arr1Index<array1.size){
        for(i in arr1Index until array1.size) array[index++] = array1[i]
    }
    if(arr2Index<array2.size){
        for(i in arr2Index until array2.size) array[index++] = array2[i]
    }
    return array
}