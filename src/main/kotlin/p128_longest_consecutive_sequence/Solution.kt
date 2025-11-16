package p128_longest_consecutive_sequence

import kotlin.math.max
/**
 *  
 */
fun main() {
    val intArray = intArrayOf(100, 4, 200, 1, 3, 2)
    println(Solution().longestConsecutive(intArray))
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var maxLength = 0

        val numSet = mutableSetOf<Int>()
        for (n in nums) {
            numSet.add(n)
        }

        for (n in numSet) {
            if (!numSet.contains((n - 1))) {
                var start = n
                var length = 1
                while (numSet.contains(++start)) {
                    length++
                }

                if (length > maxLength) {
                    maxLength = length
                }
            }
        }
        return maxLength
    }
}