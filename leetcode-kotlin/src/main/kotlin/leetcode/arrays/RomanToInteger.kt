package arrays

class Solution {
    private val numeralMap = mapOf(
        "I" to 1, "V" to 5, "X" to 10, "L" to 50,
        "C" to 100, "D" to 500, "M" to 1000
    )
    private val subtractMap = mapOf(
        "I" to Pair("V", "X"), "X" to Pair("L", "C"), "C" to Pair("D", "M")
    )

    fun romanToInt(s: String): Int {
        var r = 0
        var i = 0
        while (i <= s.lastIndex) {
            val curr = s[i].toString()
            val currV = romanValue(curr)
            val prev = s.getOrNull(i - 1).toString()
            val next = s.getOrNull(i + 1).toString()
            val nextV = romanValue(next)
            val match = subtractMap[curr]?.first == next || subtractMap[curr]?.second == next

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
                i += 1
            } else {
                r += currV
            }
            i += 1
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
