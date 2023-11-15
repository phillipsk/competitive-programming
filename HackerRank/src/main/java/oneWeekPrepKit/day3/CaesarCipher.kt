/*
 * Complete the 'caesarCipher' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun caesarCipher(s: String, k: Int): String {
    // Write your code here
    var r = ""
    for (i in s.indices) {
        var e = s[i]
        if (e.isLetter()) {
            if (e.isUpperCase()) {
                val startASCII = 'A'.code
                val endASCII = 'Z'.code
                var c = (e.code + k).toChar()
                if (c.code > endASCII) {
                    c = (startASCII + (c.code - endASCII - 1)).toChar()
                }
                r += c
            } else {
                val startASCII = 'a'.code
                val endASCII = 'z'.code
                var c = (e.code + k).toChar()
                if (c.code > endASCII) {
                    c = (startASCII + (c.code - endASCII - 1)).toChar()
                }
                r += c
            }
        } else r += e

    }
    return r
}

fun main(args: Array<String>) {

//    val result = caesarCipher("middle-Outz", 2)
//    println(result == "okffng-Qwvb")
    val result = caesarCipher("Pz-/aI/J`EvfthGH", 66)
    println(result == "Dn-/oW/X`SjthvUV")
    println(result)
}
