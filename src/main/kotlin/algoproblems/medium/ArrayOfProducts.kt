package algoproblems.medium

/**
 *
 * @author Prikshit
 *
 * Array Of Products
 *
 * */

// Time Complexity = O(N)
// Space Complexity = O(N)
fun arrayOfProducts(array: List<Int>): List<Int> {
    var a = MutableList(array.size){1}
    var t = 1
    for(i in array.indices){
        a[i] = t
        t*=array[i]
    }
    t=1
    for(i in array.size-1 downTo 0){
        a[i]*=t
        t*=array[i]
    }
    return a
}

// Time Complexity = O(N^2)
// Space Complexity = O(N)
fun arrayOfProductsNaive(array: List<Int>): List<Int> {
    var a = MutableList<Int>(array.size){1}
    for(i in array.indices){
        for(j in a.indices){
            if(i!=j) a[j] *= array[i]
        }
    }
    return a
}

