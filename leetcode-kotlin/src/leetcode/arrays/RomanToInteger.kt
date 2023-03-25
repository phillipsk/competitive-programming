package arrays

class Solution {
    private val numeralMap = mapOf(
        "I" to 1, "V" to 5, "X" to 10, "L" to 50,
        "C" to 100, "D" to 500, "M" to 1000
    )
    private val subtractSet = setOf("I", "X", "C")
    private val subtractMap = mapOf(
        "I" to Pair("V", "X"), "X" to Pair("L", "C"), "C" to Pair("D", "M")
    )
//    private val subtractSet = m.filterKeys { it == "I" || it == "X" || it == "C" }.keys

    fun romanToInt(s: String): Int {
        var r = 0
        s.mapNotNull {
            it.toString()
        }.forEachIndexed { i, curr ->
            val v = romanValue(curr)
            val prev = s.getOrNull(i - 1).toString()
            val next = s.getOrNull(i + 1).toString()
            val nextV = romanValue(next)
//            val match = subtractMap.containsKey(curr) && subtractMap[curr].first = prev
            val match = subtractMap[curr]?.first == prev || subtractMap[curr]?.second == prev
            val skip = subtractMap.containsKey(curr)
//            val match = subtractSet.contains(curr) && i > 0

            if (match) {
                when (nextV) {
                    5, 10 -> {
                        r += nextV - 1
                    }

                    50, 100 -> {
                        r += nextV - 10
                    }

                    500, 1000 -> {
                        r += nextV - 100
                    }
                }
//                i += 1
            } else if (skip) {

            } else {
                r += v
            }
        }
        return r
    }

    private fun romanValue(curr: String) = numeralMap.getOrDefault(curr, 0)
}

fun main() {
//    println(Solution().romanToInt("III"))
//    println(Solution().romanToInt("LVIII"))
    println(Solution().romanToInt("MCMXCIV"))
}
