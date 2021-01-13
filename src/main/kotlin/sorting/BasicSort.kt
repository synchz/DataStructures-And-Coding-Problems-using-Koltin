package sorting

fun main(){
    println("Bubble Sort")
    var arr = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    bubbleSort(arr)
    arr.forEach { print("$it ") }
    arr = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    println("\nSelection Sort")
    selectionSort(arr)
    arr.forEach { print("$it ") }
    arr = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    println("\nInsertion Sort")
    insertionSort(arr)
    arr.forEach { print("$it ") }
}

fun bubbleSort(arr: Array<Int>){
    var sizeCount = arr.size
    while(sizeCount>1)
        for(i in 1 until sizeCount--)
            if(arr[i-1]>arr[i]) arr[i] = arr[i-1].also{arr[i-1] = arr[i]}
}

fun selectionSort(arr: Array<Int>){
    var index = 0
    while(index<arr.size) {
        var min = index
        for(i in index until arr.size){
            if(arr[i]<arr[min]) min = i
        }
        var temp = arr[index]
        arr[index] = arr[min]
        arr[min] = temp
        index++
    }
}

fun insertionSort(arr: Array<Int>){
    if(arr.size <=1) return
    var index = 1
    while (index<arr.size){
        for(i in index downTo 1){
            var temp = arr[i-1]
            if(temp>arr[i]){
                arr[i-1] = arr[i]
                arr[i] = temp
            }else break
        }
        index++
    }
}