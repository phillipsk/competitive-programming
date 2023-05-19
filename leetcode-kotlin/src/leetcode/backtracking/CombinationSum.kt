package backtracking

import java.util.*

//  candidates = [2,3,6,7], target = 7  --> Output: [[2,2,3],[7]]
class CombinationSum {
    private fun backtrack(
        target: Int,
        nums: List<Int>,
        output: MutableList<List<Int>>,
        subtotal: Int,
        list: MutableList<Int>
    ) {
        var sum = subtotal
        var i = 0

        if (sum == target) {
            output.add(ArrayList(nums))
        }

        while (sum < target) {
            val check = ((target - sum) - nums[i]) >= 0
            if (check) {
                sum += nums[i]
                list.add(nums[i])
            } else {
                backtrack(target, nums, output, sum, list)
            }
            i++
        }

        if (sum == target) {
            output.add(list)
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val nums = candidates.toList()
        val output: MutableList<List<Int>> = mutableListOf()
        val list = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            if (target % nums[i] == 0) { // list of all the same element
                val l = target / nums[i]
                output.add(List(l) { nums[i] })
            }
        }

        backtrack(target = target, nums = nums, output = output, subtotal = 0, list)

        return output
    }
}

fun main() {
    println(CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7))
//    println(CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8))
}