package arrays

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val r = mutableListOf<List<String>>()
        val m = mutableMapOf<String, Int>()
        val mNew = mutableMapOf<String, Int>()

        strs.forEachIndexed { i, word ->
            word.forEachIndexed { j, char ->
//                println(word.windowed(j + 1))
                r.add(word.windowed(j + 1))
//                mNew[word] = word.windowed(j + 1)
            }
        }

        r.flatten().forEach {
            if (m.containsKey(it)) {
                val z = m[it]
                m[it] = z!! + 1
            } else {
                m[it] = 1
            }
        }



        val rr = m.filter {

            it.value == strs.size
        }
        val z = if (rr.isNotEmpty()) rr.keys.last() else ""

        return z
    }
}

fun main() {
        println(
            LongestCommonPrefix().longestCommonPrefix(
                arrayOf("flower", "flow", "flight")
            )
        )
    println(
        LongestCommonPrefix().longestCommonPrefix(
            arrayOf("dog", "racecar", "car")
        )
    )
}