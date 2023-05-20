package backtracking

import java.util.*

//  candidates = [2,3,6,7], target = 7  --> Output: [[2,2,3],[7]]
class CombinationSum {
    private fun backtrack(target: Int, nums: List<Int>, output: MutableList<List<Int>>, list: MutableList<Int>) {
        var sum = 0
        var subtotal = target
        for (i in nums.indices) {
            if (nums[i] == subtotal) {
                list.add(nums[i])
                output.add(list)
                break
            } else if (nums[i] < subtotal) {
                sum += nums[i]
                subtotal -= nums[i]
                list.add(nums[i])
            }
        }

        if (sum > 0) {
            backtrack(subtotal, nums, output, list)
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val nums = candidates.toList()
        val output: MutableList<List<Int>> = mutableListOf()
        val list = mutableListOf<Int>()
/*        for (i in 0 until nums.size) {
            if (target % nums[i] == 0) { // list of all the same element
                val l = target / nums[i]
                output.add(List(l) { nums[i] })
            }
        }*/

        backtrack(target = target, nums = nums, output = output, list)

        return output
    }
}

fun main() {
    println(CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7))
//    println(CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8))
}