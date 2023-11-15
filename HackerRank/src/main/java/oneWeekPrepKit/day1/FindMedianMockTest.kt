package src.main.java.oneWeekPrepKit.day1


/*
 * Complete the 'findMedian' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun findMedian(arr: Array<Int>): Int {
    // Write your code here
    return if (arr.size % 2 != 0) { // constraints say only odd sized arrays provided
        arr.sort()
        arr[arr.size/2]
    } else 0


}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr: Array<Int> = arrayOf(0, 1, 2, 4, 6, 5, 3)

    val result = findMedian(arr)

    println(result)
}
