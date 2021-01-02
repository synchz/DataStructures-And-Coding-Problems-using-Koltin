package leetcode

/**
 *
 * @author Prikshit
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * */

fun main(){
    for(i in 0..10)
        println("step $i ->${climbStairs(i)}")
}

fun climbStairs(n:Int) : Int{
    return when(n) {
        0,1 -> 1
        else -> {
            var prev = 1
            var next = 1
            var count = n - 1
            while (count-- > 0)
                next += prev.also { prev = next }
            next
        }
    }
}

fun climbStairsR(n: Int): Int {
    var fibArrayList = arrayListOf(1, 1)
    fun climbRecursive(step:Int):Int{
        return if (step < fibArrayList.size) fibArrayList[step]
        else
            (climbRecursive(step - 1) + climbRecursive(step - 2)).let {
                fibArrayList.add(it)
                it
            }
    }
    return climbRecursive(n)
}