package src.main.java.oneWeekPrepKit.day2


/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    // Write your code here
//    val mapSum = mutableMapOf<Int, Int>()
    for (i in 1 until matrix.size) {
        val row = matrix[i]
        var pRow = matrix[i - 1]
//        var rSum = row.sum()
        if (row.sum() > pRow.sum()) {
            val tmp = pRow
            pRow = row
            matrix[i - 1] = pRow
            matrix[i] = tmp
        }
    }
    for (c in matrix) {
    }
    println(matrix)
    return 0
}

fun main(args: Array<String>) {

    val matrix = Array(4) {
        when (it) {
            0 -> arrayOf(112, 42, 83, 119)
            1 -> arrayOf(56, 125, 56, 49)
            2 -> arrayOf(15, 78, 101, 43)
            3 -> arrayOf(62, 98, 114, 108)
            else -> error("Matrix size exceeded")
        }
    }

//    val matrix = Array<Array<Int>>(2) {
//        arrayOf(1, 2)
//        arrayOf(3, 4)
//    }

    val result = flippingMatrix(matrix)

    println(result)
}
