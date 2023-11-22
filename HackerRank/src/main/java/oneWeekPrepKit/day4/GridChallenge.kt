package src.main.java.oneWeekPrepKit.day4

/*
 * Complete the 'src.main.java.oneWeekPrepKit.day4.gridChallenge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY grid as parameter.
 */

fun gridChallenge(grid: Array<String>): String {
    // Write your code here
    for(i in 0 until grid.size) {
        val tmp = grid[i].toCharArray().sorted().joinToString("")
        grid[i] = tmp
    }
    // println(grid.joinToString())

    for(i in 0 until grid.size - 1) {
        for(j in 0 until grid[0].length) {
            // print("${grid[i][j]} //")
            // print("${grid[i+1][j]} //")

            if(grid[i][j] > grid[i+1][j]) return "NO"
        }
    }

    return "YES"
}

fun transpose(grid: Array<String>): Array<String> {
    val numRows = grid.size
    val numCols = grid[0].length
    val transposedGrid = Array(numCols) { "" }

    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            transposedGrid[j] += grid[i][j].toString()
        }
    }

    return transposedGrid
}

fun main(args: Array<String>) {

//    val grid = arrayOf("eabcd", "fghij", "olkmn", "trpqs", "xywuv")
    val grid = arrayOf("abc", "hjk", "mpq", "rtv")
//    val grid = arrayOf("mpxz", "abcd", "wlmf")
    val result = gridChallenge(grid)
//    val result = transpose(grid).joinToString()
// maw, pbl, xcm, zdf // unsorted
// maf, pbl, xcm, zdw // sorted

    println(result)
}