package src.main.java.warmUpChallenges

/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

fun repeatedString(s: String, n: Long): Long {
    // Write your code here
    if(s.length == 1) return n
    val rStr: String = if(s.length > n) s else {
        val r = (s.length % n).toInt()
        // print("${s.length % n} // r $r //")
        s.repeat(r) + s[0]
    }
    // print("rStr $rStr // ")
    var c: Long = 0

    for(i in rStr.indices) {
        if(rStr[i] == 'a') c++
    }

    return c
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
