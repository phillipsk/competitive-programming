package src.main.java.oneWeekPrepKit.day2

/*
 * Complete the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var sum1 = 0
    var sum2 = 0
    for (r in 0 until arr.size) {
        for (c in arr.indices) {
            if (r == c) {
                sum1 += arr[r][c]
            }
            if ((r + c) == arr.size -1) {
                sum2 += arr[r][c]
            }
        }
    }
    return kotlin.math.abs(sum1 - sum2)
}

fun main(args: Array<String>) {

    var arr = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(9, 8, 9)
    )

//    arr = arrayOf(
//        arrayOf(11, 2, 4),
//        arrayOf(4, 5, 6),
//        arrayOf(10, 8, -12)
//    )

    val result = diagonalDifference(arr)

    println(result)
}
