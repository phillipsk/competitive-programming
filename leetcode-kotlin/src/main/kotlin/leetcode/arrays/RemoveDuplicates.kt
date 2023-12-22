package arrays

import kotlin.math.absoluteValue

class SolutionRemoveDuplicates {

    inline fun IntArray.sumOf(selector: (Int) -> Int): Int {
        var sum: Int = 0.toInt()
        for (element in this) {
            sum += selector(element)
        }
        return sum
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1 || (nums.sum() == nums.size) || nums.sumOf { it.absoluteValue } == 0) {
            return 1
        }
        for (i in 0..nums.size) {
            var j = i

            while (j < nums.size && nums[j] <= nums[i]) {
                j++
            }
            if (i < nums.size && j < nums.size) {
                val tmp = nums[i + 1]
                nums[i + 1] = nums[j]
                nums[j] = tmp
            }
        }
        var counter = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                counter++
            } else {
                break
            }
        }

        return counter
    }
    internal class SolutionEditorial {
        fun removeDuplicates(nums: IntArray): Int {
            var insertIndex = 1
            for (i in 1 until nums.size) {
                // We skip to next index if we see a duplicate element
                if (nums[i - 1] != nums[i]) {
                    /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                    nums[insertIndex] = nums[i]
                    insertIndex++
                }
            }
            return insertIndex
        }
    }

    class SolutionTwoPointers {
        fun removeDuplicates(nums: IntArray): Int {
            var i = 0
            var l = 0
            var r = 0
            while (r < nums.size) {
                while (r < nums.size && nums[r] == nums[l]) {
                    r++
                }
                nums[i] = nums[l]
                i++
                l = r
            }
            return i
        }
    }
}

fun main() {
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(-50,-50,-49,-49,-48,-48,-48,-47,-47,-47,-47,-47,-46,-45,-45,-45,-44,-43,-43,-42,-41,-41,-41,-40,-39,-38,-37,-37,-37,-35,-34,-34,-33,-33,-32,-31,-30,-29,-29,-28,-28,-28,-28,-26,-26,-25,-24,-24,-23,-22,-22,-21,-21,-20,-20,-19,-19,-18,-17,-17,-17,-17,-16,-16,-15,-14,-13,-13,-13,-12,-12,-12,-11,-11,-9,-8,-8,-7,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-3,-1,-1,-1,-1,-1,0,1,1,2,3,3,3,4,5,5,5,5,6,7,7,8,8,8,8,8,8,9,9,10,10,10,10,11,11,12,12,12,12,12,14,15,15,16,16,17,18,18,19,19,19,20,20,21,21,22,23,23,24,24,25,25,25,26,26,28,30,30,30,31,31,33,33,33,34,34,34,34,34,37,38,38,39,40,40,40,41,41,41,41,41,41,41,43,43,44,44,45,46,46,46,46,48,48,49,50)))

    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(1, 2, 2)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(0, 0, 0, 0, 3)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(0, 0, 0, 0, 0)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(1, 1)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(1, 2)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(1, 1, 2)))
    println(SolutionRemoveDuplicates.SolutionEditorial().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    /*
        89
        2
        2
        1
        1
        2
        2
        5
*/
}