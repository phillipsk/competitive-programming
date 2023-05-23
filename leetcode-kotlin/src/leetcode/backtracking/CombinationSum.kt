package backtracking

//  candidates = [2,3,6,7], target = 7  --> Output: [[2,2,3],[7]]
//  candidates = [2,3,5], target = 8 --> Output: [[2,2,2,2],[2,3,3],[3,5]]
class CombinationSum {
    private fun backtrack(
        target: Int,
        nums: IntArray,
        output: MutableList<List<Int>>,
        list: MutableList<Int>,
        idx: Int
    ) {
        var list = mutableListOf<Int>()
        var subtotal = target
        var sum = 0

        for (i in idx until nums.size) {
            if (subtotal % nums[i] == 0 && subtotal < target) {
                val l = subtotal / nums[i]
                val ints = List(l) { nums[i] }
                list.addAll(ints)
                subtotal -= ints.sum()
            }
            if (subtotal == 0) {
                output.add(list)
                list = mutableListOf()
                subtotal = target
            } else {
                sum += nums[i]
                list.add(nums[i])
                subtotal -= nums[i]
            }
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val nums = candidates
        val output: MutableList<List<Int>> = mutableListOf()
        val list = mutableListOf<Int>()
        for (i in nums.indices) {
            if (target % nums[i] == 0) { // list of all the same element
                val l = target / nums[i]
                output.add(List(l) { nums[i] })
            }
        }

        backtrack(target = target, nums = nums, output = output, list, 0)

        return output
    }
}

fun main() {
//    println(CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8))
}