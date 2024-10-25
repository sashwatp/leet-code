package p347_top_k_frequent_elements

import java.util.PriorityQueue

fun main() {
    val arr = intArrayOf(5, 3, 1, 1, 1, 3, 73, 1)
    val k = 2

    println(Solution().topKFrequent(arr, k).joinToString(","))
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (n in nums) {
            if (map.contains(n)) {
                map[n] = map[n]!! + 1
            } else {
                map[n] = 1
            }
        }

        println("Map$map")


        val minHeap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        for (n in map.keys) {
            minHeap.add(Pair(n, map[n]!!))
        }

        println(minHeap)

        return IntArray(k) { minHeap.poll().first }
    }

}