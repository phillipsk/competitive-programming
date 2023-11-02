package src.main.java.oneWeekPrepKit.day2

/*
 * Complete the 'lonelyinteger' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun lonelyinteger(a: Array<Int>): Int {
    // Write your code here
    a.sort()
    var r: Int? = null
    for (i in 0..a.size step 2) {
        if (r != null) {
            break
        }
        if (i == a.size - 1) {
            r = a[a.size - 1]
        } else if (a[i + 1] != a[i]) {
            r = a[i]
        }
    }
    return r ?: 0
}

fun main(args: Array<String>) {
//    val n = readLine()!!.trim().toInt()

    var a = arrayOf(1, 2, 3, 4, 3, 2, 1) //readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    a = arrayOf(7, 7, 4, 3, 4, 3, 6)
    val result = lonelyinteger(a)

    println(result)
}
