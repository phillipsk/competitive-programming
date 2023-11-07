package src.main.java.oneWeekPrepKit.day3


fun findZigZagSequence(arr: Array<Int>): Array<Int> {
//    arr.sort()
    for (i in 0 until arr.size / 2) {
        val tmp = arr[i]
        arr[i] = arr[arr.lastIndex - i]
        arr[arr.lastIndex - i] = tmp
    }
    return arr
}

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    /*
        val t = readLine()!!.trim().toInt() // test cases
        val n = readLine()!!.trim().toInt() // arr size

        val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    */

//    produce a collection of integers [ a, b, c, d, e ] such that a < b > c < d > e
//    val arr = arrayOf(2, 3, 5, 1, 4) // arrayOf(1, 4, 5, 3, 2)
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7) // 1 2 3 7 6 5 4
    val result = findZigZagSequence(arr)

    println(result.joinToString(","))
}

/*
*
* fun findZigZagSequence(arr: Array<Int>): Array<Int>  {
//    arr.sort()
        println("arr.size/2 :: ${arr.size/2}")
        println("arr.size :: ${arr.size}")
    for(i in (arr.size + 1)/2  until arr.size) {
        print("$i ")
        val tmp = arr[i] // tmp: 4
        arr[i] = arr[arr.lastIndex - i]
        arr[arr.lastIndex - i] = tmp
    }
    println()
    // println(arr.size/2)
    return arr
}
* */