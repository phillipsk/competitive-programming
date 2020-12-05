package leetcode

class Solution {
    fun twoSumOLD(nums: IntArray, target: Int): IntArray {
        var t: Int
        var r = IntArray(2)
        for (i in nums) {
            for (j in nums) {
                t = i + j
                if (t == target) {
                    r = intArrayOf(nums.indexOf(i), nums.indexOf(j))
//                    r.sort()
                }
            }
        }
        return r
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = hashMapOf<Int, Int>()
        for ((index, value) in nums.withIndex()) {
            var a = target - value
            if (map.containsKey(a)) {
                return intArrayOf(index, map.get(a)!!)
            }
            map.put(value, index)
        }
        return intArrayOf()
    }

    // 方法一
    fun twoSumIII(numbers: IntArray, target: Int): IntArray {
        var height = numbers.size - 1
        var low = 0;
        while (low < height) {
            val sum = numbers[low] + numbers[height]
            when {
                sum == target -> return intArrayOf(low + 1, height + 1)
                sum < target -> low++
                else -> height--
            }
        }
        return intArrayOf()
    }

    // 方法二
    fun twoSum2(numbers: IntArray, target: Int): IntArray {

        numbers.forEachIndexed { i, value ->
            val index = binarySearch(numbers, i + 1, target - value)
            if (index != -1) {
                return intArrayOf(i + 1, index + 1)
            }
        }

        return intArrayOf()
    }

    fun binarySearch(numbers: IntArray, start: Int, target: Int): Int {
        var low = start
        var height = numbers.size - 1
        while (low <= height) {
            val mind = (low + height) ushr 1
            when {
                numbers[mind] == target -> return mind
                numbers[mind] < target -> low = mind + 1
                else -> height = mind - 1
            }
        }
        return -1
    }
}

fun main() {
    fun caller(nums: IntArray, target: Int) {
//        v.forEach(::print)
//        Solution().twoSum(nums, target).joinToString { "," }
        var v = Solution().twoSumIII(nums, target)
        v.sort()
        v.joinToString { "," }
        println(v)
//        println()
    }

    var nums = intArrayOf(2, 7, 11, 15)
    var target = 9
//    caller(nums, target)
    print(Solution().twoSumOLD(nums, target).contentToString())

    nums = intArrayOf(3, 2, 4)
    target = 6
    caller(nums, target)

    nums = intArrayOf(3, 3)
    target = 6
    caller(nums, target)


}
