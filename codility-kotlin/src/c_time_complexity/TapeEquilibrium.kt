import kotlin.math.abs

fun solution(A: IntArray): Int {
    // first non-empty part
    var left = A[0]
    // second non-empty part
    var right = A.slice(1 until A.size).sum()

    var minDiff = abs(left - right)
    for (i in 1 until A.size - 1) {
        left += A[i]
        right -= A[i]
        if (minDiff > abs(left-right)) {
            minDiff = abs(left-right)
        }
    }
    return minDiff
}
fun main() {
    check(200 == solution(listOf(3,1,2,4,3).toIntArray()))
//    check(200 == solution(listOf(-100, 100).toIntArray()))

}
