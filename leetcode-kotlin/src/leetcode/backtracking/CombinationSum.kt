package backtracking

//  candidates = [2,3,6,7], target = 7  --> Output: [[2,2,3],[7]]
//  candidates = [2,3,5], target = 8 --> Output: [[2,2,2,2],[2,3,3],[3,5]]
class CombinationSum {
    private fun backtrack(
        target: Int,
        nums: IntArray,
        output: MutableList<List<Int>>
    ) {
        val list = mutableListOf<Int>()
        var subtotal = target

        for (i in nums.indices) {
            while (subtotal > 0) {
                if (subtotal % nums[i] == 0) {
                    val l = subtotal / nums[i]
                    val ints = List(l) { nums[i] }
                    if (!output.contains(ints)) {
                        list.addAll(ints)
                        subtotal -= ints.sum()
                    } else {
                        break
                    }
                }

                list.add(nums[i])
                subtotal -= nums[i]

                if (nums.contains(subtotal)) {
                    list.add(subtotal)
                    subtotal -= subtotal
                }
            }

            if (list.isNotEmpty()) {
                output.add(list)
            }
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val output: MutableList<List<Int>> = mutableListOf()
        val list = mutableListOf<Int>()
        for (i in candidates.indices) {
            if (target % candidates[i] == 0) { // list of all the same element
                val l = target / candidates[i]
                output.add(List(l) { candidates[i] })
            }
        }

        backtrack(target = target, nums = candidates, output = output)

        return output.distinct()
    }
}

fun main() {
//    println(CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8))
//    println(CombinationSum().combinationSum(intArrayOf(2), 1))
}