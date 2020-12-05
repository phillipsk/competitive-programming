package b_arrays

fun solution(A: IntArray): Int {
    if (A.size == 1) {
        return A[0]
    }

    A.sort() // critical step

    for (i in 0..A.size step 2) {
        if (i == A.size - 1) {
            return A[i]
        }

        if (A[i] != A[i + 1]) {
            return A[i]
        }
    }

    return -1
}
fun main() {
    print(solution(intArrayOf(9,3,9,3,9,7,9)))
//    check(1 == solution(listOf(1, 1, 2, 3, 4).toIntArray())) // TODO: incorrect check
//    read assumptions, all but one element has a matching pair
    check(2 == solution(listOf(1, 1, 2, 4, 4).toIntArray()))
}
