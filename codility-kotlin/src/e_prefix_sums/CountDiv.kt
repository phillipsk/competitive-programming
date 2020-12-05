package e_prefix_sums

fun solution(A: Int, B: Int, K: Int): Int {
//    if (A !in 0..2_000_000_000 && B !in 0..2_000_000_000 &&
//        K !in 1..2_000_000_000 && A >= B) return 0
//
//    var c = 0
//    for (i in A..B) {
//        if (i % K == 0) c++
//    }
//    var offsetForLeftRange = 0
//    if (A % K == 0) {
//        ++offsetForLeftRange
//    }
//    var a = B / K - (A - 1) / K
    if (A == B && B == 0)
        return 1

    if (A > 0)
        return B / K - (A - 1) / K

    if (A == 0)
        return B / K + 1

    return 0
//    return B / K - A / K + offsetForLeftRange
//    return c

}

fun main() {
    check(3 == solution(6, 11, 2))
}