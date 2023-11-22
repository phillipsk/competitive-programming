package src.main.java.oneWeekPrepKit.day4

/*
 * Complete the 'src.main.java.oneWeekPrepKit.day4.gridChallenge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY grid as parameter.
 */

fun gridChallenge(grid: Array<String>): String {
    // Write your code here
    var isAlphaDesc = true
    val numRows = grid.size
    val numCols = grid[0].length
    val list = Array(numCols) { "" }
    for (i in 0 until numRows) {
        val tmp = grid[i].toCharArray().sorted().joinToString("")
        grid[i] = tmp
//        list[i] = tmp

        for (j in 0 until numCols) {
//            l.add(grid[i][j])
            var t1 = ""
            t1 += grid[i][j]
            list[j] += t1

//            list[j] += grid[i][j]

//            list[j].toCharArray()[i] = grid[i][j]
//            tmp = grid[i]

//            val tmp = j .toCharArray().sorted().joinToString("")

            isAlphaDesc = t1 == t1.toCharArray().sorted().joinToString("")
            if (!isAlphaDesc) {
                break
            }
        }
    }
    println(list.joinToString())
    return if (isAlphaDesc) "YES" else "NO"
}

fun main(args: Array<String>) {

//    val grid = arrayOf("eabcd", "fghij", "olkmn", "trpqs", "xywuv")
    val grid = arrayOf("mpxz", "abcd", "wlmf")
// maf,
    val result = gridChallenge(grid)

    println(result)
}