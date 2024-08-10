package p49_group_anagrams

fun main () {
    println(GroupAnagrams().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
}
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<Array<Int>, MutableList<String>>()

        for (ele in strs) {
            val sorted = sortedString(ele)
            if (map.containsKey(sorted)) {
                map[sorted]?.add(ele)
            } else {
                map[sorted] = mutableListOf(ele)
            }
        }
        return map.values.toList()
    }

    private fun sortedString(s: String): Array<Int> {
        val arr = Array(26) {0}

        for (i in s.indices) {
            arr[s[i].lowercaseChar().code - 97]++
        }
        return arr
    }
}