package f_sorting

fun solution(A: IntArray): Int {
//    if (A.size !in 0..100000)
    return A.distinct().count()

}

fun main() {
    check(3 == solutionMP(intArrayOf(2, 1, 1, 2, 3, 1)))
}