package src.main.java.warmUpChallenges

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    // only count the number of valleys
    var vc = 0
    var count = 0
    for(i in path.indices) {
        val e = path[i]
        // print("$e ")
        if (e.toString() == "U") {
            // print("mountain ")
            count++
            if(count == 0) vc++
        } else {
            // print("valley ")
            count--
        }
    }
    // print("$vc // $mc ")
    return vc

}

fun countingValleysGPT(steps: Int, path: String): Int {
    // Write your code here
    var level = 0
    var valleyCount = 0

    for (step in path) {
        if (step == 'U') {
            level++
            if (level == 0) {
                valleyCount++
            }
        } else if (step == 'D') {
            level--
        }


    }

    return valleyCount
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
