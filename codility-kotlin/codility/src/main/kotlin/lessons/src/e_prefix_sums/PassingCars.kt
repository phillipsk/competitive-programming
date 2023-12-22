package e_prefix_sums

fun solution(A: IntArray): Int {
    val limit = 1_000_000_000

    if (A.size > 100000) {
        return -1
    }

    var sum = 0
    var numberOfOnes = 0

    for (elem in A.reversed()) {
        if (sum > limit) {
            return -1
        }

        if (elem == 1) {
            numberOfOnes += 1
        } else if (elem == 0) {
            sum += numberOfOnes
        }
    }

    return sum
}

fun main() {
    check(5 == solution(listOf(0, 1, 0, 1, 1).toIntArray()))
}
