package src.main.java.oneWeekPrepKit.day2

/*
 * Complete the 'countingSort' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun countingSort(arr: Array<Int>): Array<Int> {
    // Write your code here
    arr.sort()
    val list = Array(arr.size) { 0 }
    for (i in arr.indices) {
        list[arr[i]]++
    }
    return list
}

fun main(args: Array<String>) {

    val arr = arrayOf(4, 2, 2, 8, 3, 3, 1, 7, 5, 6)

    val result = countingSort(arr)

    println(result.joinToString(" "))
}
