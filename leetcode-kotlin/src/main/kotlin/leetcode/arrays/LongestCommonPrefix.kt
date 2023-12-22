package arrays

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val r = mutableListOf<List<String>>()
        val m = mutableMapOf<String, Int>()
        val mNew = mutableMapOf<String, MutableList<List<String>>>()

        strs.forEachIndexed { i, word ->
            word.forEachIndexed { j, char ->
                r.add(word.windowed(j + 1))
            }
            mNew[word] = r
        }

        mNew.values.flatten().flatten().forEach {
            if (m.containsKey(it)) {
                val z = m[it]
                m[it] = z!! + 1
            } else {
                m[it] = 1
            }
        }

        val k = m

        val rr = m.filter {

            it.value == strs.size
        }
        val z = if (rr.isNotEmpty()) rr.keys.last() else ""

        return z
    }

    fun longestCommonPrefixHorizontal(strs: Array<String>): String? {
        if (strs.isEmpty()) return ""
        var prefix = strs[0] // sticky first word
        for (i in 1 until strs.size) while (strs[i].indexOf(prefix) != 0) {
            // reduce length of first word if length does not match second, third, etc.. word
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) {
                return ""
            }
        }
        return prefix
    }

    fun longestCommonPrefixVertical(strs: Array<String>?): String? {
        if (strs.isNullOrEmpty()) return ""
        for (i in 0 until strs[0].length) { // iterates over first word
            val c = strs[0][i] // first word characters
            for (j in 1 until strs.size) { // iterate over i-th letter of each word
                if (i == strs[j].length || strs[j][i] != c) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}

fun main() {
    println(
        LongestCommonPrefix().longestCommonPrefixVertical(
            arrayOf("flower", "flow", "flight")
        )
    )
    println(
        LongestCommonPrefix().longestCommonPrefixVertical(
            arrayOf("dog", "racecar", "car")
        )
    )
}