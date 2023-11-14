package src.main.java.arrays

fun hourglassSum(arr: Array<Array<Int>>): Int {
    val rows = arr.size
    val columns = arr[0].size
    var maxSum = Int.MIN_VALUE

    for (i in 0 until rows - 2) {
        for (j in 0 until columns - 2) {
            val currentSum = (
                    arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                            arr[i + 1][j + 1] +
                            arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
                    )

            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }
    }

    return maxSum
}

fun main() {
    val inputArray = arrayOf(
        arrayOf(1, 1, 1, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 0, 0, 0),
        arrayOf(0, 0, 2, 4, 4, 0),
        arrayOf(0, 0, 0, 2, 0, 0),
        arrayOf(0, 0, 1, 2, 4, 0)
    )

    val result = hourglassSum(inputArray)
    println("Maximum Hourglass Sum: $result")
}
