package p35_search_insert_position

fun main() {
    val ans = searchInsert(listOf(1).toIntArray(), 1)

    println(ans)
}


fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0;
    var end = nums.size-1;

    while (start <= end) {

        /**
         * If array length is big. mid = (start + end) / 2 may cause overflow  integer issue and can create
         * ArrayIndexOutOfBoundException.
         */
        val pivot = start + (end - start) / 2

        if (nums[pivot] == target) {
            return pivot
        } else {
            if (nums[pivot] > target) {
                end = pivot - 1
            } else {
                start = pivot + 1
            }
        }
    }

    return start;
}