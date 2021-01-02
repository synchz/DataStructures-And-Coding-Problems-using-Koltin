package leetcode

/**
 *
 * @author Prikshit
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 * */

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
    threeSum(arrayOf(0,-1,0,1,0).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
    println("Fourth Case")
    threeSum(arrayOf(-1,0,1,2,-1,-4).toIntArray()).forEach { list->
        list.forEach { print("$it ") }
        println()
    }
}

fun threeSum(nums: IntArray): List<List<Int>> {

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
