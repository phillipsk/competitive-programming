package src.main.java.oneWeekPrepKit.day4

/*
 * Complete the 'src.main.java.oneWeekPrepKit.day4.gridChallenge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY grid as parameter.
 */

fun gridChallenge(grid: Array<String>): String {
    // Write your code here
    for (i in grid.indices) {
        grid[i] = grid[i].toCharArray().apply { sort() }.joinToString("")
    }
    val length = grid[0].length
    val r = Array(length) { "" }.toMutableList()
    for (i in 0 until length) {
        for (j in 0 until length) {
            r[j].toCharArray()[i] = grid[j][i]
        }
        r[i] = r[i]
    }
    return grid.joinToString() +"\n " + r.joinToString()
}

fun main(args: Array<String>) {

    val grid = arrayOf("eabcd", "fghij", "olkmn", "trpqs", "xywuv")

    val result = gridChallenge(grid)

    println(result)
}