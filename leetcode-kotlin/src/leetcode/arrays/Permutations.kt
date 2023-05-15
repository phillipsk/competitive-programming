package arrays

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val m = mutableListOf<MutableList<Int>>()
        var k = 0
        while (k < nums.size) {
            val list = mutableListOf<Int>()
            for (i in 0 until nums.size) {
                list.add(nums[i])
            }
            m.add(list)
            for (j in 1 until nums.size) {
                val t = nums[j]
                nums[j] = nums[j - 1]
                nums[j - 1] = t
            }
            k++
        }
        return m
    }
}

fun main() {
//    [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    println(Permutations().permute(intArrayOf(1, 2, 3)))
    println(Permutations().permute(intArrayOf(0, 1)))
    println(Permutations().permute(intArrayOf(1)))
}