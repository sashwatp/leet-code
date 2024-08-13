package p76_min_window_substring

import kotlin.math.min

fun main() {
    val s = "asdfbasdf"
//    println(s[0])
//    println(s[0].code)
    println(Solution().minWindow("cabwefgewcwaefgcf", "cae"))
//    println(Solution().minWindow("aaa", "aa"))
}

class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) {
            return ""
        } else if (t == "") {
            return ""
        }

        val tArr = charCount(t)

        var start = 0
        var end = 0
        var minStart = start
        var minEnd = end - 1

        val arr = Array(150) { 0 }

        while (end < s.length) {
            increamentCount(arr, s[end])
            if (hasAllChar(tArr, arr)) {
                minStart = start
                minEnd = end
                break
            }
            end++
        }

        while (start < s.length && start < end) {
            arr[getAscii(s[start])]--
//            println(s.substring(start, end + 1))
            if (tArr[getAscii(s[start])] == 0 || arr[getAscii(s[start])] >= tArr[getAscii(s[start])]) {
                start++
                if (hasAllChar(tArr, arr) && minEnd - minStart > end - start) {
                    minStart = start
                    minEnd = end
                }
            } else {
                start++
                while (end < s.length - 1) {
                    end++
                    arr[getAscii(s[end])]++
                    if (s[end] == s[start-1]) {
                        if (minEnd - minStart > end - start) {
                            minStart = start
                            minEnd = end
                        }
                        break
                    }
                }
            }
        }
        return s.substring(minStart, minEnd + 1)
    }

    private fun charCount(s: String): Array<Int> {
        val arr = Array(150) { 0 }

        for (i in s.indices) {
            arr[getAscii(s[i])]++
        }
        return arr
    }

    private fun getAscii(c: Char): Int = c.code

    private fun hasAllChar(ref: Array<Int>, s: Array<Int>): Boolean {
        for (i in ref.indices) {
            if (s[i] < ref[i])
                return false
        }
        return true
    }

    private fun increamentCount(arr: Array<Int>, c: Char) {
        arr[getAscii(c)]++
    }

    private fun decrementCount(arr: Array<Int>, c: Char) {
        arr[getAscii(c)]--
    }
}