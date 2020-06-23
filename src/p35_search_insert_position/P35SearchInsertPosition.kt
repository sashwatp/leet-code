package p35_search_insert_position

fun main() {
    val ans = searchInsert(listOf(1).toIntArray(), 1)

    println(ans)
}


fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0;
    var end = nums.size-1;

    if (nums.isEmpty()) {
        return 0
    }

    if (nums[0] > target) {
        return 0
    }

    if (nums[nums.size - 1] < target) {
        return nums.size
    }

    while (start <= end) {
        val mid = (start + end)/2
        println(mid)
        if (nums[mid] == target) {
            return mid
        } else {
            if (target < nums[mid]) {
                if (mid > 0 && nums[mid-1] < target) {
                    return mid
                } else {
                    end = mid;
                }
            } else {
                start = mid + 1
            }
        }
    }

    return -1
}