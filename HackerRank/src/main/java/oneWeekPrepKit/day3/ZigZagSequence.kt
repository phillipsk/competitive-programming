package src.main.java.oneWeekPrepKit.day3


fun findZigZagSequenceI(arr: Array<Int>): Array<Int> {
//    arr.sort()
    for (i in 0 until arr.size / 2) {
        val tmp = arr[i]
        arr[i] = arr[arr.lastIndex - i]
        arr[arr.lastIndex - i] = tmp
    }
    return arr
}

fun findZigZagSequenceIII(a: Array<Int>): Array<Int> {
    a.sort()
    return ((a.slice(0 until a.size / 2) + a[a.size - 1] + a.slice(a.size / 2 until a.size - 1).reversed()).toTypedArray())
}

fun findZigZagSequenceII(arr: Array<Int>): Array<Int> {
    arr.sort() // Sort the input array in ascending order

    // Swap adjacent elements starting from the second element
    for (i in 1 until arr.size - 1 step 2) {
        val temp = arr[i]
        arr[i] = arr[i + 1]
        arr[i + 1] = temp
    }

    return arr
}

fun findZigZagSequence(arr: Array<Int>): Array<Int> {
    // Sort the input array in ascending order
    val sortedArr = arr.sortedArray()

    // Divide the sorted array into two halves
    val n = sortedArr.size
    val firstHalf = sortedArr.slice(0 until n / 2)
    val secondHalf = sortedArr.slice(n / 2 until n)

    // Interleave the elements from the first and second halves
    val zigzagSequence = mutableListOf<Int>()

    for (i in 0 until n / 2) {
        zigzagSequence.add(firstHalf[i])
        zigzagSequence.add(secondHalf[i])
    }

    // If the input array has an odd number of elements, add the middle element
    if (n % 2 == 1) {
        zigzagSequence.add(sortedArr[n / 2])
    }

    return zigzagSequence.toTypedArray()
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