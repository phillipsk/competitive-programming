package src.main.java.oneWeekPrepKit.day2

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'lonelyinteger' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun lonelyinteger(a: Array<Int>): Int {
    // Write your code here
    a.sort()
    var r = 0
    for (i in 0..a.size step 2) {
        if (i == a.size - 1) {
            r = a[a.size - 1]
        } else if (a[i + 1] != a[i]) {
            r = a[i]
        }
    }
    return r
}

fun main(args: Array<String>) {
//    val n = readLine()!!.trim().toInt()

    val a = arrayOf(1, 2, 3, 4, 3, 2,1) //readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = lonelyinteger(a)

    println(result)
}
