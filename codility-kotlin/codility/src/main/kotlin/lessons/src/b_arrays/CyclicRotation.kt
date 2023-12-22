package b_arrays

fun solution(A: IntArray, K: Int): IntArray {
    if (A.size == 1 || A.isEmpty() || A.size == K) {
        return A
    }

    val shifts = K % A.size // critical step

    val result = IntArray(A.size)
    for (i in A.indices) {
        if (i + shifts < A.size) {
            result[i + shifts] = A[i]
        } else {
            result[i + shifts - A.size] = A[i]
        }
    }
    return result
}


fun main() {
//    var v = solution(intArrayOf(3, 8, 9, 7, 6), 3)
    var v = solution(IntArray(10) { it * 1000 }, 19)
    print(v.contentToString())

    check(emptyArray<Int>().toIntArray().contentEquals(solution(emptyArray<Int>().toIntArray(), 0)))
    check(listOf(9, 7, 6, 3, 8).toIntArray().contentEquals(solution(listOf(3, 8, 9, 7, 6).toIntArray(), 3)))
    check(listOf(1, 2, 3, 4).toIntArray().contentEquals(solution(listOf(1, 2, 3, 4).toIntArray(), 4)))
    check(listOf(0, 0, 0).toIntArray().contentEquals(solution(listOf(0, 0, 0).toIntArray(), 1)))
}
