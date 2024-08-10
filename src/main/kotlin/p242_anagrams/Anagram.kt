package p242_anagrams

fun main() {
    println(Anagram().isAnagram("a", "b"))
}

class Anagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val countArrS = Array(26) {0}
        val countArrT = Array(26) {0}


        for (i in s.indices) {
            countArrS[s.get(i).lowercaseChar().code - 97]++
            countArrT[t.get(i).lowercaseChar().code - 97]++
        }

        for (i in 0..25) {
            if (countArrS[i] != countArrT[i]) {
                return false
            }
        }
        return true
    }
}