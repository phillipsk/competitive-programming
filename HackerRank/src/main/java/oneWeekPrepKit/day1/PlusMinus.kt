package src.main.java.oneWeekPrepKit.day1

import java.text.DecimalFormat

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here
    val decimalFormat = DecimalFormat("0.000000")
    val n = decimalFormat.format(arr.size).toDouble()
    val positiveNumbers = arr.count { it > 0 }
    val negativeNumbers = arr.count { it < 0 }
    val zeroNumbers = arr.count { it == 0 }

    println(String.format("%.6f", positiveNumbers / n))
    println(String.format("%.6f", negativeNumbers / n))
    println(String.format("%.6f", zeroNumbers / n))

}

fun main(args: Array<String>) {

    var n: Int = 5 // readLine()!!.trim().toInt()

    var arr: Array<Int> = arrayOf(1, 1, 0, -1, -1)
    // readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    plusMinus(arr)
}
