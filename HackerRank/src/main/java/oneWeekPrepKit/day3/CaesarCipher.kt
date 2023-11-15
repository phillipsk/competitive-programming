/*
 * Complete the 'caesarCipher' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun caesarCipher(s: String, k: Int): String {
    var result = ""
    for (char in s) {
        if (char.isLetter()) {
            var startASCII = 'A'.code
            var endASCII = 'Z'.code
            var c = (char.code + k).toChar()

            if (char.isLowerCase()) {
                startASCII = 'a'.code
                endASCII = 'z'.code
            }

            if (c.code > endASCII) {
                c = (startASCII + ((c.code - endASCII - 1) % 26)).toChar()
            }
            result += c
        } else {
            result += char
        }
    }
    return result
}

fun main(args: Array<String>) {

//    val result = caesarCipher("middle-Outz", 2)
//    println(result == "okffng-Qwvb")
    val result = caesarCipher("Pz-/aI/J`EvfthGH", 66)
    println(result == "Dn-/oW/X`SjthvUV")
    println(result)
}
