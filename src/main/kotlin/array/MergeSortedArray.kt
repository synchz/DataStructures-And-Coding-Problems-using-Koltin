package array

/**
 *
 * @author Prikshit
 *
 * Merge two sorted arrays
 *
 * */
fun main(){
    var arr = mergeSortedArray(arrayOf(-1, 0, 10, 26), arrayOf(0, 8, 24))
    arr.forEach { print("$it ") }
}


// This solution is O(n)
fun mergeSortedArray(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    var mergedArray = Array<Int>(arr1.size + arr2.size) { 0 }
    if(arr1.isEmpty()) return arr2
    if(arr2.isEmpty()) return arr2
    var index1 = 0
    var index2 = 0
    var mergedIndex = 0
    while(index1<arr1.size || index2<arr2.size){
        if(index2>= arr2.size ||( index1 < arr1.size && arr1[index1]<arr2[index2]))  mergedArray[mergedIndex++] = arr1[index1++]
        else mergedArray[mergedIndex++] = arr2[index2++]
    }
    return mergedArray
}

// This solution is O(n^2)
fun `mergeSortedArrayOn^2`(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    var mergedArray = Array<Int>(arr1.size + arr2.size) { 0 }
    var index = 0
    var mergedArrayIndex = 0
    for(int in arr1){
        while(index<arr2.size && int>=arr2[index]){
            mergedArray[mergedArrayIndex] = arr2[index]
            index++
            mergedArrayIndex++
        }
        mergedArray[mergedArrayIndex] = int
        mergedArrayIndex++
    }
    return mergedArray
}