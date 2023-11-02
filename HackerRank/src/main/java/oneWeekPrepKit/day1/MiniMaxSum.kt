package src.main.java.oneWeekPrepKit.day1

import kotlin.collections.*
import kotlin.ranges.*

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    val s = arr.sorted()
    val min = s.slice(0 until arr.size - 1).map { it.toLong() }.sum()
    val max = s.slice(1 until arr.size).map { it.toLong() } .sum()

    print("$min $max")

}

fun main(args: Array<String>) {

    val arr: Array<Int> = arrayOf(1, 3, 5, 7, 9)

    miniMaxSum(arr)
}
