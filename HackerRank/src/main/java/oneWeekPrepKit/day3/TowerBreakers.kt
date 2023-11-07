package src.main.java.oneWeekPrepKit.day3

/*
 * Complete the 'towerBreakers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER m
 */

fun towerBreakers(n: Int, m: Int): Int {
    // Write your code here
    // player 1 always goes first
    // both players play optimally
    var c = 0
    val list = mutableListOf<Int>()
    // val t = (n * m)+1
    // println(t)

    for(i in 1 until m) {
        // print("$i ")
        if(m % i == 0) {
            // print("modulo true")
            for(j in 1..n) list.add(i)
        }
    }

    println(list.joinToString(","))
    return -1
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val result = towerBreakers(n, m)

        println(result)
    }
}
