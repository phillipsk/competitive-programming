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
    val size = grid.size
    val list = Array(size) { "" }
    var tmp: String
    for (i in 0 until size) {
        tmp = grid[i].toCharArray().sorted().joinToString("")
        grid[i] = tmp
//        list[i] = tmp
        for (j in 0 until size) {
//            l.add(grid[i][j])
            list[j] += grid[i][j]

            list[j].toCharArray()[i] = grid[i][j]
            tmp = grid[i]

//            val tmp = j .toCharArray().sorted().joinToString("")

//            isAlphaDesc = tmp == tmp.toCharArray().sorted().joinToString("")
//            if (!isAlphaDesc) {
//                break
//            }
        }
    }
    println(list.joinToString())
    return if (isAlphaDesc) "YES" else "NO"
}

fun main(args: Array<String>) {

    val grid = arrayOf("eabcd", "fghij", "olkmn", "trpqs", "xywuv")
//    val grid = arrayOf("mpxz", "abcd", "wlmf")

    val result = gridChallenge(grid)

    println(result)
}