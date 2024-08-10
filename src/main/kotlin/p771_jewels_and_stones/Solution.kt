package p771_jewels_and_stones

fun main() {
    println(numJewelsInStones("aA", "AaAnsdf"))
}

    fun numJewelsInStones(J: String, S: String): Int {
        val jewels  = J.toCharArray().toHashSet()

        return S.toCharArray()
            .filter { jewels.contains(it) }
            .count()
    }
