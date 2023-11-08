package src.main.java.oneWeekPrepKit.day4

/*
 * Complete the 'src.main.java.oneWeekPrepKit.day4.gridChallenge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY grid as parameter.
 */

fun gridChallenge(grid: Array<String>): String {
    // Write your code here
    // only rearrange rows
    for (i in grid.indices) { // sort rows
        val s = grid[i]
        val t = s.toCharArray().sorted().joinToString("")
        grid[i] = t
    }

    // sort columns
    // val list = MutableList<String>(grid.size) {""}
    val list = Array(grid[0].length) { "" }
    var isColumnAsc = false

    for (i in list.indices) { // sort columns
        var t = ""
        for (r in grid.indices) { // 0..4
            t += grid[r][i]
        }
        list[i] = t
    }
//    println("${list.joinToString()}")

    for (e in list) {
        isColumnAsc = e == e.toCharArray().sorted().joinToString("")
        if (!isColumnAsc) break
    }

    return if (isColumnAsc) "YES" else "NO"
}

// editorial
fun canSortGrid(rows: List<String>): Boolean {
    val numRows = rows.size
    val numCols = rows[0].length

    for (col in 0 until numCols) {
        for (row in 1 until numRows) {
            if (rows[row - 1][col] > rows[row][col]) {
                return false
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    val input = """
eabcd
fghij
klmno
pqrst
uvwxy
""".trimIndent().lines()

    val grid = input.toTypedArray()
    val result = gridChallenge(grid)

    println(result)

}

/*
afkpu
bglqv
chmrw
dinsx
ejoty
*/