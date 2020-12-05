package codility

fun solution(A: IntArray, K: Int): Boolean {
    val n = A.size
    for (i in 0 until n - 1) {
        if (A[i] + 1 < A[i + 1]) // KP --> ensures array is sorted, with minimal 1 integer gap
            return false
    }
//    if (A[0] != 1 && A[n - 1] != K)
//    if (A[0] != 1 && A[n - 1] != K || A[0] == 0 && A[n - 1] != K)
//    if (A[0] != 1 && A[n - 1] != K && A[0] != 0)
//    if (A[0] != 1 && A[n - 1] != K && A[0] != 0 && A[n-1] <= K)
    if (A[0] < 0 || K > A[n-1])
        return false
    else
        return true
}

fun main() {
    check(solution(intArrayOf(1, 1, 2, 3, 3), 3))
    check(!solution(intArrayOf(1, 1, 3), 2))
    check(solution(intArrayOf(0, 1, 2, 3), 2))
    check(solution(intArrayOf(0, 1, 2, 3), 3))
    check(solution(intArrayOf(0, 1, 2, 3), 1))
    check(solution(intArrayOf(0, 1, 2, 3), 0))
    check(!solution(intArrayOf(0, 1, 2, 3), 6))
}