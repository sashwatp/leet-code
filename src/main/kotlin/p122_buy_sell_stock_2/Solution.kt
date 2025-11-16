package p122_buy_sell_stock_2

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
*/
fun main() {
    println("This")
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for (i in 1..<prices.size) {
            if (prices[i] - prices[i-1] > 0) {
                profit += prices[i] - prices[i-1]
            }
        }
        return profit
    }
}