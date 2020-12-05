package c_time_complexity

fun solution(A: IntArray): Int {
//    critical step sum possible total outcome
    val expected = (A.size.toDouble() + 1) * (A.size.toDouble() + 2) / 2
    val real = A.map { it.toDouble() }.sum()

    return (expected - real).toInt()
}
fun main() {
    check(4 == solution(listOf(2, 3, 1, 5).toIntArray()))
//    Not appicable assumption, must be an ordered list or permutation
    check(4 == solution(listOf(9999, 1113, 2121, 23545).toIntArray()))
}
