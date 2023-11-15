package src.main.java.oneWeekPrepKit.day1

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    var sum = 0L
    var minNum = Long.MIN_VALUE
    var maxNum = Long.MAX_VALUE
    for(i in arr.indices) {
        var e = arr[i].toLong()
        sum+= e
        minNum = minOf(e, minNum)
        maxNum = maxOf(e, maxNum)
    }
    print("$minNum $maxNum")
    // print("$minNum $maxNum")


}

fun main(args: Array<String>) {

    val arr: Array<Int> = arrayOf(1, 3, 5, 7, 9)

    miniMaxSum(arr)
}
