package d_counting_elements

import java.util.*


fun solutionMI(A: IntArray): Int {
    val expected = (A.size.toDouble()) * (A.size.toDouble() - 1) / 2
    val real = A.map { it.toDouble() }.sum()

    var diff = (expected - real).toInt()

    A.sort()
    var min = 0
    var bCheck = false
    for (i in 0 until A.size) {

        if (i > 0 && !bCheck) {
            min = i
            bCheck = true
            //&& A[i] > min) min = A[i] // set minimum integer from array
        }

        if (i > min) {

        }

    }
    return min

}

fun solutionMIrevised(A: IntArray): Int {
    val seen = HashSet<Int>()
    val min = 1

    for (i in 0 until A.size) {
        if (A[i] > 0) seen.add(A[i])
    }

    for (i in 1 until Int.MAX_VALUE) {
        if (!seen.contains(i)) return i
    }

    return min

}

fun main() {
    check(5 == solutionMIrevised(intArrayOf(1, 3, 6, 4, 1, 2)))
    check(4 == solutionMIrevised(intArrayOf(1, 2, 3)))
    check(1 == solutionMIrevised(intArrayOf(-1, -3)))
}

