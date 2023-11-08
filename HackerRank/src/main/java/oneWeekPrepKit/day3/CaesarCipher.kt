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
    return TODO()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}
