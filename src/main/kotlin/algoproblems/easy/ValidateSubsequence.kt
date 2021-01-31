package algoproblems.easy

/**
 *
 * @author Prikshit
 *
 * Validate Subsequence
 *
 * */

//Time O(N)
//Space O(1)
fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var i =0
    var j =0
    while(i<array.size && j<sequence.size){
        if(sequence[j] == array[i++]) j++
    }
    return j == sequence.size
}
