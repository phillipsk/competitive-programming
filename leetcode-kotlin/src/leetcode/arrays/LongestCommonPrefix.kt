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

    fun longestCommonPrefixEditorialJava(strs: Array<String>): String? {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]
        for (i in 1 until strs.size) while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) {
                return ""
            }
        }
        return prefix
    }
}

fun main() {
    println(
        LongestCommonPrefix().longestCommonPrefixEditorialJava(
            arrayOf("flower", "flow", "flight")
        )
    )
    println(
        LongestCommonPrefix().longestCommonPrefixEditorialJava(
            arrayOf("dog", "racecar", "car")
        )
    )
}