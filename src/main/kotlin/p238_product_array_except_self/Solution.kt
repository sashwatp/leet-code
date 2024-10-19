package p238_product_array_except_self

fun main() {
    val intArray = intArrayOf(1, 2, 4)

    println(Solution().productExceptSelf(intArray).joinToString(","))
}

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        if (nums.isEmpty())
            return intArrayOf()

        val result = IntArray(nums.size)

        result[0] = 1
        for (i in 1..<nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var right = 1

        for (i in nums.size - 1 downTo 0) {
            result[i] *= right
            right *= nums[i]
        }
        return result
    }
}