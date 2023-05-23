package backtracking

//  candidates = [2,3,6,7], target = 7  --> Output: [[2,2,3],[7]]
class CombinationSum {
    private fun backtrack(
        target: Int,
        nums: IntArray,
        output: MutableList<List<Int>>,
        list: MutableList<Int>,
        idx: Int
    ) {
        var list = mutableListOf<Int>()
        for (i in nums.indices) {
            var subtotal = target
            var sum = 0

            WhileLoop@ while (subtotal != 0) {

                for (j in nums.indices) {
                    if (subtotal in 1 until target && subtotal % nums[j] == 0 && !output.contains(listOf(subtotal))) { // list of all the same element
                        val l = subtotal / nums[j]
                        list.addAll(List(l) { nums[j] })
                        if (!output.contains(list)) {
                            output.add(list)
                        } else {
                            break
                        }
//                        subtotal = 0
                        list = mutableListOf()
                        break@WhileLoop
                    }
                }

                if (list.sum() == target) {
                    output.add(list)
                    subtotal = 0
                    list = mutableListOf()
                    break
                    // rotate array
                    /*                    for (j in idx until nums.size) {
                                                    val t = nums[j]
                                                    nums[j] = nums[j - 1]
                                                    nums[j - 1] = t
                                                    backtrack(target = target, nums = nums, output = output, mutableListOf(), idx + 1)
                                                }*/
                }

                //  && nums[i] <= subtotal
                sum += nums[i]
                list.add(nums[i])
                subtotal -= nums[i]

                if (nums.contains(subtotal) && !output.contains(listOf(subtotal))
                //                    && nums.indexOf(subtotal) == i
                ) { // edge case
                    list.add(subtotal)
                    if (list.sum() == target) {
                        output.add(list)
                        subtotal = 0
                        list = mutableListOf()
                        break
                        // rotate array
                        /*                        for (j in idx until nums.size) {
                                                            val t = nums[j]
                                                            nums[j] = nums[j - 1]
                                                            nums[j - 1] = t
                                                            backtrack(target = target, nums = nums, output = output, mutableListOf(), idx + 1)
                                                        }*/
                    }
                }

                if (subtotal < nums.min()) {
                    break
                }

            }
            // rotate array
            /*            val t = nums[i]
                        nums[i] = nums[i + 1]
                        nums[i + 1] = t*/
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val nums = candidates
        val output: MutableList<List<Int>> = mutableListOf()
        val list = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            if (target % nums[i] == 0) { // list of all the same element
                val l = target / nums[i]
                output.add(List(l) { nums[i] })
            }
        }

        backtrack(target = target, nums = nums, output = output, list, 1)

        return output
    }
}

fun main() {
//    println(CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8))
}