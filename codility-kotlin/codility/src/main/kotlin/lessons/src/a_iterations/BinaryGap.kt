package a_iterations

fun solution(N: Int): Int {
    val zeroAndOnes = Integer.toBinaryString(N)
        .replace(Regex("0+$"), "")

    val zeros = zeroAndOnes.split(Regex("1+"))

    val lengths = zeros.map(String::length)
        .filter { it > 0 }

//    return lengths.max()!!.or(0)
    return lengths.max() ?: 0 // Elvis operator // TODO: incorrect operator condition

}

fun main() {
    println(solution(9913))
    solution(5)
    solution(15)
    solution(32)
    check(2 == solution(9913))
}
