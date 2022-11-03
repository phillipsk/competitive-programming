val nums = listOf(1, 0, -1, 0, -2, 2)
val target = 0
val output = listOf(listOf(-2, -1, 1, 2), listOf(-2, 0, 0, 2), listOf(-1, 0, 0, 1))

nums.sum()

output.size
output.forEach {
    println(it.sum() == target)
}
