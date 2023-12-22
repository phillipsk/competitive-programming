package arrays

class ReverseStringII {
    fun reverseStr(s: String, k: Int): String {
        TODO("Testing Editorial")
        val cArr = s.toCharArray()
        val l = cArr.lastIndex
        val step = k * 2

        return if (l < k) {
            cArr.reverse()
            String(cArr)
        } else if (l < step) {
            cArr.reverse(0, k)
            String(cArr)
        } else if (l % k > 0) {
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

    internal class EditorialSolution {
        fun reverseStr(s: String, k: Int): String {
            val cArr = s.toCharArray()
            var start = 0
            while (start < cArr.size) {
                var i = start
                var j = Math.min(start + k - 1, cArr.size - 1)
                while (i < j) {
                    val tmp = cArr[i]
                    cArr[i++] = cArr[j]
                    cArr[j--] = tmp
                }
                start += 2 * k
            }
            return String(cArr)
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
//    println(ReverseStringII.EditorialSolution().reverseStr("abcdefg", 2))
//    println(ReverseStringII.EditorialSolution().reverseStr("abcd", 2))
//    println(ReverseStringII.EditorialSolution().reverseStr("abcdef", 3))
    println(ReverseStringII.EditorialSolution().reverseStr("abcd", 4)) // dcba
//    println(ReverseStringII.EditorialSolution().reverseStr("abcdefg", 4))

    /*    println(
            ReverseStringII.EditorialSolution().reverseStr(
                "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknv" +
                        "dmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39
            )
        )*/

/*    println(
        ReverseStringII.EditorialSolution().reverseStr(
            "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubew" +
                    "llxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc", 20
        )
    )*/

}