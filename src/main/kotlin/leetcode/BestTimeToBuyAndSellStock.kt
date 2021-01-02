package leetcode

/**
 *
 * @author Prikshit
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * */

fun main(){
    println(maxProfit(arrayOf(7,1,5,3,6,4).toIntArray()))
    println(maxProfit(arrayOf(7,6,4,3,1).toIntArray()))
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var minPrice = Int.MAX_VALUE
    prices.forEach { current->
        if(current < minPrice) minPrice = current
        else if(current - minPrice > profit) profit = current - minPrice
    }
    return profit
}