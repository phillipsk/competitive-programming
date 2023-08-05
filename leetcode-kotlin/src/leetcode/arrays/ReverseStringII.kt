package arrays

class ReverseStringII {
    fun reverseStr(s: String, k: Int): String {
        val cArr = s.toCharArray()
        val l = cArr.lastIndex
        val step = k * 2
        var ss: String = ""

        return if (l < k) {
            cArr.reverse()
            String(cArr)
        } else if (l < step && l >= k) {
            cArr.reverse(0, k)
            String(cArr)
        } else if (l % k > 0) {
            var cc = charArrayOf()
            val e = l / k
            for ((c, i) in (0 until l step step).withIndex()) {
                if (c == 0) {
                    cArr.reverse(i, k)
                } else {
                    cArr.reverse(i, l + 1)
                }
            }
            String(cArr)
        } else {
            for (i in 0 until l step step) {
                val t = cArr[i]
                val i1 = i + (k - 1)
                cArr[i] = cArr[i1]
                cArr[i1] = t
            }
            String(cArr)
        }
    }
}

public fun CharArray.reverse(fromIndex: Int, toIndex: Int): Unit {
//    AbstractList.checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

fun main() {
//    println(ReverseStringII().reverseStr("abcdefg", 2))
//    println(ReverseStringII().reverseStr("abcd", 2))
//    println(ReverseStringII().reverseStr("abcdef", 3))
//    println(ReverseStringII().reverseStr("abcd", 4)) // dcba
//    println(ReverseStringII().reverseStr("abcdefg", 4))
    println(
        ReverseStringII().reverseStr(
            "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknv" +
                    "dmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39
        )
    )
    // fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh

//    "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl"
//    "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi"
}