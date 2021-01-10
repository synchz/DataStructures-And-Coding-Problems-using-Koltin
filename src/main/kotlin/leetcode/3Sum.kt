package leetcode

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 * */

import kotlin.collections.*

fun main(){
    println("First Case")
    threeSum(arrayOf(-1,0,1).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
    println("Second Case")
    threeSum(arrayOf(-1,0).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
    println("Third Case")
    threeSum(arrayOf(0,-1,-1,0,1,0,0).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
    println("Fourth Case")
    threeSum(arrayOf(0, 0, 0, -1,-1,1,-4,2).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
}

fun threeSum(nums: IntArray): List<List<Int>>{
    var sol = ArrayList<List<Int>>()
    if(nums.size<3) return sol
    nums.sort()
    for(firstNumberPointer in 0 until nums.size-2){
        var secondNumberPointer = firstNumberPointer+1
        var thirdNumberPointer = nums.size-1
        if(firstNumberPointer>0 && nums[firstNumberPointer]==nums[firstNumberPointer-1]) continue
        while(secondNumberPointer<thirdNumberPointer){
            (nums[firstNumberPointer]+nums[secondNumberPointer]+nums[thirdNumberPointer]).let{
                when{
                    it == 0 -> {
                        sol.add(listOf(nums[firstNumberPointer], nums[secondNumberPointer], nums[thirdNumberPointer]))
                        while(secondNumberPointer<thirdNumberPointer && nums[secondNumberPointer] == nums[secondNumberPointer+1]) secondNumberPointer++
                        while(secondNumberPointer<thirdNumberPointer && nums[thirdNumberPointer] == nums[thirdNumberPointer-1]) thirdNumberPointer--
                        secondNumberPointer++
                        thirdNumberPointer--
                    }
                    it > 0  -> {
                        while(secondNumberPointer<thirdNumberPointer && nums[thirdNumberPointer] == nums[thirdNumberPointer-1]) thirdNumberPointer--
                        thirdNumberPointer--
                    }
                    else ->{
                        while(secondNumberPointer<thirdNumberPointer && nums[secondNumberPointer] == nums[secondNumberPointer+1]) secondNumberPointer++
                        secondNumberPointer++
                    }
                }
            }
        }
    }
    return sol
}

//On^2 but space complexity is O2n
fun threeSumOn2(nums: IntArray): List<List<Int>> {

    var sol = ArrayList<List<Int>>()
    if(nums.size<3) return sol
    var mapOfNums = HashMap<Int, Int>()
    for(num in nums)
        mapOfNums[num] = if(mapOfNums.containsKey(num)) mapOfNums[num]!! + 1 else   1
    var tempSet = HashSet<Int>()
    fun canPairWithThisKey(number:Int):Boolean{
        return mapOfNums.containsKey(number) && mapOfNums[number]!!>0 && !tempSet.contains(number)
    }
    fun addToList(first:Int, second:Int, third:Int){
        tempSet.add(second)
        tempSet.add(third)
        sol.add(listOf(first, second, third))
    }
    fun addIfCan(first:Int, second:Int, third:Int){
        if(canPairWithThisKey(third)) addToList(first, second, third)
    }
    for((firstKey, firstCount) in mapOfNums){
//        Empty temp set
        tempSet = HashSet()
        for((secondKey, secondCount) in mapOfNums){
//            Key is already used
            if(secondCount == 0) continue
            var thirdNumber = -1*(firstKey + secondKey)

            if(firstKey == secondKey){
//                If number is 0
                if(firstKey == 0 && firstCount>2) sol.add(listOf(0,0,0))
                else if(firstKey != 0 && firstCount>1){
                    addIfCan(firstKey, secondKey, thirdNumber)
                }
            }else{
                if(thirdNumber == firstKey || thirdNumber == secondKey){
                    if(mapOfNums[thirdNumber]!! > 1) addIfCan(firstKey, secondKey, thirdNumber)
                }else addIfCan(firstKey, secondKey, thirdNumber)
            }
        }
//        Mark key as used
        mapOfNums[firstKey] = 0
    }
    return sol
}
