package backtracking

import java.util.*


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

    inner class Solution {
        val ans = mutableListOf<List<Int>>()
        fun permute(nums: IntArray): List<List<Int>> {
            backtrack(nums, mutableSetOf<Int>())

            return ans
        }

        fun backtrack(nums: IntArray, used: MutableSet<Int>) {
            if (nums.size == used.size) {
                ans.add(used.toList())
                return
            }

            for (num in nums) {
                if (num in used) continue

                used.add(num)
                backtrack(nums, used)
                used.remove(num)
            }
        }
    }

    inner class SolutionEditorial {
        private fun backtrack(n: Int, input: ArrayList<Int>, output: MutableList<List<Int>>, first: Int) {
            // if all integers are used up
            if (first == n) {
                output.add(ArrayList(input))
            }
            for (i in first until n) {
                // place i-th integer first
                // in the current permutation
                Collections.swap(input, first, i)
                // use next integers to complete the permutations
                backtrack(n, input, output, first + 1)
                // backtrack
                Collections.swap(input, first, i)
            }
        }

        fun permute(nums: IntArray): List<List<Int?>?> {
            // init output list
            val output: MutableList<List<Int>> = mutableListOf()

            // convert nums into list since the output is a list of lists
            val input = ArrayList<Int>()
            for (num in nums) input.add(num)
            val n = nums.size
            backtrack(n = n, input = input, output = output, first = 0)
            return output
        }
    }
}

fun main() {
//    [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    println(Permutations().Solution().permute(intArrayOf(1, 2, 3)))
    println(Permutations().SolutionEditorial().permute(intArrayOf(1, 2, 3)))
//    println(Permutations().permute(intArrayOf(0, 1)))
//    println(Permutations().permute(intArrayOf(1)))
}