package algoexpert.easy

/**
 *
 * @author Prikshit
 *
 * https://www.algoexpert.io/questions/Find%20Three%20Largest%20Numbers
 *
 * */

fun main(){
    findThreeLargestNumbers(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7))
}

//Time complexity O(N)
//Space Complexity O(1)
fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    var sol  = mutableListOf(Int.MIN_VALUE,Int.MIN_VALUE,Int.MIN_VALUE)
//    O(n)
    for(i in array){
        var t = -1
//        O(k) k=3
        for(j in sol.indices){
            if(i>sol[j]){
                t  = j
                if(j>0) sol[j-1] = sol[j]
            }
            else break
        }
        if(t>-1) sol[t] = i
//        O(k) k=3
//        shiftElementsToLeftAndUpdate(sol, t, i)
    }
    return sol
}

fun shiftElementsToLeftAndUpdate(arr:MutableList<Int>, index:Int, value:Int){
    if(index == -1 || index>=arr.size) return
    for(i in 0 until index){
        arr[i] = arr[i+1]
    }
    arr[index] = value
}