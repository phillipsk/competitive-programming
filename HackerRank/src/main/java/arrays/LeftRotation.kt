package src.main.java.arrays

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    // Write your code here
    for(j in 1..d) {
        for(i in 1 until a.size) {
            val tmp = a[i - 1]
            a[i - 1] = a[i]
            a[i] = tmp
        }
    }

    return a
}

fun main(args: Array<String>) {

    val result = rotLeft(arrayOf(1,2,3,4,5), 4)

    println(result.joinToString(" "))
}
