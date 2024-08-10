package p34_find_first_n_last_position_of_element_in_sorted_array

import p35_search_insert_position.searchInsert

fun main() {
    val ans = searchRange(intArrayOf(1), 1)

    println(ans)
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    return intArrayOf(firstOcc(nums, target), lastOcc(nums, target))
}

fun firstOcc(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size -1

    while(start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target && (mid == 0 || nums[mid-1] != target)) {
            return mid
        } else {
            if (nums[mid] >= target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
    }
    return -1
}

fun lastOcc(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size -1

    while(start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target && (mid == nums.size - 1 || nums[mid+1] != target)) {
            return mid
        } else {
            if (nums[mid] <= target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }
    return -1
}