package src.main.java.arrays

/*
 * Complete the 'reverseArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun reverseArray(a: Array<Int>): Array<Int> {
    // Write your code here
    for (i in 0 until a.size / 2) {
        val tmp = a[i]
        a[i] = a[a.lastIndex - i]
        a[a.lastIndex - i] = tmp
    }
    return a
}

fun main(args: Array<String>) {
    val arr = arrayOf(1, 4, 3, 2)

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
