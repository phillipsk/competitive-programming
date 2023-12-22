package leetcode.backtracking

class FourSumSolution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val r = mutableListOf<Int>()
        nums.forEachIndexed { index, i ->
            if (index != nums.lastIndex) {
//            while (index <= nums.lastIndex) {
                val nextIndex = index + 1
                val nextElement = nums.elementAt(nextIndex)
                val subtotal = i + nextElement
                val match = (subtotal == target)
                if (match) {
                    r.add(i)
                    r.add(nums.elementAt(nextIndex))
                }
            }
        }
        return listOf(r)
    }
    fun fourSumUsingTwoPointers(nums: IntArray, target: Int): List<List<Int>> {
        val n = nums.size
        val ans = hashSetOf<ArrayList<Int>>()

        // In-place algo
        nums.sort()
        var sum: Int
        for (i in 0 until n - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            for (j in i + 1 until n - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                var left = j + 1
                var right = n - 1

                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if (sum > target) {
                        right--
                    } else if (sum == target) {
                        ans.add(
                            ArrayList<Int>().apply {
                                add(nums[i])
                                add(nums[j])
                                add(nums[left])
                                add(nums[right])
                            }
                        )
                        left++
                    } else {
                        left++
                    }
                }
            }
        }
        return ans.map { it }
    }

//    val nums = intArrayOf(1, 0, -1, 0, -2, 2)
    fun fourSumii(nums: IntArray, target: Int): List<List<Int>> {
        var res = mutableListOf<MutableList<Int>>()

        if (nums.isEmpty()) return res

        nums.sort()
        val n = nums.size.toInt()
//      i = 0; j = 1; left = 2; right = (size - 1)
        var i = 0
        var j = 0
        while (i < n) {
            j = i+1
            while (j < n) {
                var left = j+1
                var right = n-1

                while (left < right) {
                    val cursum = nums[i]+nums[j]+nums[left]+nums[right]
                    if (cursum == target) {
                        res.add(mutableListOf(nums[i], nums[j], nums[left], nums[right]))

                        while (left < right && nums[left] == nums[left+1]) ++left
                        while (left < right && nums[right] == nums[right-1]) --right
                        ++left
                        --right
                    } else if (cursum < target) {
                        ++left
                    } else {
                        --right
                    }
                }
                while (j+1 < n && nums[j] == nums[j+1]) ++j
                ++j
            }
            while (i+1 < n && nums[i] == nums[i+1]) ++i
            ++i
        }
        return res
    }
}

fun main() {
    val nums = intArrayOf(1, 0, -1, 0, -2, 2)
    val target = 0
    val output = listOf(listOf(-2, -1, 1, 2), listOf(-2, 0, 0, 2), listOf(-1, 0, 0, 1))

//    println(FourSumSolution().fourSum(nums, target))
//    println(FourSumSolution().fourSumUsingTwoPointers(nums, target))
    println(FourSumSolution().fourSumii(nums, target))
}