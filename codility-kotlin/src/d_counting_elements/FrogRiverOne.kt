package d_counting_elements


fun solution(X: Int, A: IntArray): Int {
//    critical step sum possible total outcome
    val shouldBeSum = X * (X + 1) / 2
//    use hashmap to hash unique dict key
    val seen = hashSetOf<Int>()

    var sum = 0
    for (elem in A.withIndex()) {
        if (!seen.contains(elem.value)) {
            sum += elem.value
            seen.add(elem.value)
            if (sum == shouldBeSum) {
                return elem.index
            }
        }
    }
    return -1
}

fun kpSolution(X: Int, A: IntArray): Int {
    val seen = hashSetOf<Int>()
    for (e in A.withIndex()) {
        if (!seen.contains(e.value)) {
            seen.add(e.value)
            if (seen.contains(X)) return e.index
        }
    }
    return -1
}


fun main() {
    check(4 == kpSolution(4, listOf(1, 3, 1, 4, 2, 3, 5, 4).toIntArray()))
    check(6 == kpSolution(5, listOf(1, 3, 1, 4, 2, 3, 5, 4).toIntArray()))
    check(-1 == kpSolution(5, listOf(1, 3, 1, 4, 2, 3, 6, 4).toIntArray()))
    check(-1 == kpSolution(2, listOf(2, 2, 4).toIntArray()))

//    check(6 == solution(5, listOf(1, 3, 1, 4, 2, 3, 5, 4).toIntArray()))
//    check(-1 == solution(5, listOf(1, 3, 1, 4, 2, 3, 6, 4).toIntArray()))
//    check(-1 == solution(2, listOf(2, 2, 4).toIntArray()))

}

