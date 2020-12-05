package c_time_complexity

//Slow solution — time complexity O(n2).
fun slowSolution(n: Int): Int {
    var result = 0
    for (i in 0 until IntArray(n).size) {
        for (j in 0 until IntArray(n).size) {
            result += 1
        }
    }
    return result
}

//Fast solution — time complexity O(n).
fun fastSolution(n: Int): Int {
    var result = 0
    for (i in 0 until IntArray(n).size) {
        result += (i + 1)
    }
    return result
}

//Model solution — time complexity O(1).
fun modelSolution(n: Int): Int {
    val result = (n * (n + 1)) / 2
    return result
}

fun main() {
    check(81 == slowSolution(9))
    check(45 == fastSolution(9))
    check(45 == modelSolution(9))
}

