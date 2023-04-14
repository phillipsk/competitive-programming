package arrays

class SolutionLCS {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size in 0..1) return nums.size
        nums.sort()
        var max = 0
        var counter = 1
        for (i in 1 until nums.size) {
            if (nums[i] - nums[i - 1] == 1) {
                counter++
            } else if (nums[i] - nums[i - 1] == 0) {
                continue
            } else {
                if (counter > max) {
                    max = counter
                }
                counter = 1
            }
        }
        return maxOf(counter, max)
    }
}

fun main() {
    /*    assert(SolutionLCS().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)) == 9)
        assert(SolutionLCS().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)) == 4)
        assert(SolutionLCS().longestConsecutive(intArrayOf(1, 2, 0, 1)) == 3)*/
    println(SolutionLCS().longestConsecutive(intArrayOf(1, 2, 0, 1)))
}