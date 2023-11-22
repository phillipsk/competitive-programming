package src.main.java.arrays

/*
 * Complete the 'compareTriplets' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    val list = Array(2) { 0 }
    for (i in a.indices) {
        if (a[i] > b[i]) list[0]++
        else if (a[i] < b[i]) list[1]++
//            val eq = a[i] == b[j]
//        println("a ${a[i]} :: b ${b[i]} //")
    }
    return list
}

fun main(args: Array<String>) {

    val a = arrayOf(5, 6, 7)

    val b = arrayOf(3, 6, 10)

    val result = compareTriplets(a, b)

    println(result.joinToString(" "))
}
