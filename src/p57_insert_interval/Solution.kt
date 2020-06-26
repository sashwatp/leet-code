package p57_insert_interval

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val start = findStart(intervals, newInterval)
    val end = findEnd(intervals, newInterval, start)

    if (intervals[start])
}

fun findStart(intervals: Array<IntArray>, newInterval: IntArray): Int {
    var start = 0
    var end = intervals.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (newInterval[0] == intervals[mid][0]) {
            return mid
        } else {
            if (newInterval[0] > intervals[mid][0]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    return start
}

fun findEnd(intervals: Array<IntArray>, newInterval: IntArray, astart:Int = 0):Int {
    var start  = astart
    var end = intervals.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (newInterval[1] == intervals[mid][1]) {
            return mid
        } else {
            if (newInterval[0] > intervals[mid][0]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    return start
}