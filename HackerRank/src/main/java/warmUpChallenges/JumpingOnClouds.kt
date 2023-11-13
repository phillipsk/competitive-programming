package src.main.java.warmUpChallenges

/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */

fun jumpingOnClouds(c: Array<Int>): Int {
    // Write your code here
    var jumps = 0
    var i = 0
    while(i < c.size - 1) {
        if(c[i] == 0 && c[i+1] == 0) {
            jumps+= 2
            i+= 2
        } else {
            jumps++
            i++
        }
        print("i jumps :: $i $jumps // ")
    }

    // var j = i
    // while(j < c.size && c[j] == 0 && j <= (j + 2)) {
    //     // if(c[j] == 0) {
    //         jumps++
    //     // }
    //     j++
    //     print("j :: $j // ")
    // }
    // print("jumps :: $jumps // ")
    return jumps
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
