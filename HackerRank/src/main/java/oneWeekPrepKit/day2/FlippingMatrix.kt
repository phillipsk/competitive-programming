package src.main.java.oneWeekPrepKit.day2


/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    val n = matrix.size
    var totalSum = 0

    for (layer in 0 until n / 2) {
        for (i in 0 until n / 2) {
            val maxElement = maxOf(
                matrix[layer][i],
                matrix[layer][n - i - 1],
                matrix[n - layer - 1][i],
                matrix[n - layer - 1][n - i - 1]
            )
            totalSum += maxElement
        }
    }
    return totalSum
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

/*    val matrix = Array<Array<Int>>(2) {
        arrayOf(1, 2)
        arrayOf(3, 4)
    }*/

    val result = flippingMatrix(matrix)

    println(result)
}
