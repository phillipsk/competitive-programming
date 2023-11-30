package src.main.java.arrays

/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    // Write your code here
    var lastAnswer = 0
    val arr = Array(n) { mutableListOf<Int>() }
    queries.forEach {
        val x = it[1]
        val y = it[2]
        val idx = (x xor lastAnswer) % n
        when {
            it[0] == 1 -> { // 1
                arr[idx][arr[idx].size] = y
            }

            it[1] == 2 -> { // 2
                lastAnswer = arr[idx][y % arr[idx].size]
            }
        }
    }
    return arr[1].toTypedArray()
}

fun main(args: Array<String>) {

    val queries = Array(5) {
        when (it) {
            0 -> arrayOf(1, 0, 5)
            1 -> arrayOf(1, 1, 7)
            2 -> arrayOf(1, 0, 3)
            3 -> arrayOf(2, 1, 0)
            4 -> arrayOf(2, 1, 1)
            else -> throw IllegalArgumentException("Index out of bounds")
        }
    }

//    val queries = arrayOf(
//        intArrayOf(1, 0, 5),
//        intArrayOf(1, 1, 7),
//        intArrayOf(1, 0, 3),
//        intArrayOf(2, 1, 0),
//        intArrayOf(2, 1, 1)
//    )


    val result = dynamicArray(2, queries)

    println(result.joinToString("\n"))
}
