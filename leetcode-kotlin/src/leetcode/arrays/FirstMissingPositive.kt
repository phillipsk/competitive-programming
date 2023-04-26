package arrays

class FirstMissingPositive {

    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()
        for (i in 1..nums?.max() as Int) {
            if (i in 1 until nums?.max() as Int) {
                if (!nums.contains(i)) {
                    return i
                }
            }
        }
        if (nums.all { it <= 0 }) {
            return 1
        } else if (nums.sum() == 1) {
            return 2
        } else {
            return nums?.max() as Int + 1
        }
    }
}

fun main() {
    println(SolutionEditorial().firstMissingPositive(intArrayOf(3, 4, -1, -2, 1, 5, 16, 0, 2, 0)))
    println(SolutionEditorial().firstMissingPositive(intArrayOf(-10, -3, -100, -1000, -239, 1)))
    println(SolutionEditorial().firstMissingPositive(intArrayOf(-5)))
    println(SolutionEditorial().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    println(SolutionEditorial().firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(SolutionEditorial().firstMissingPositive(intArrayOf(1, 2, 0)))
}

internal class SolutionEditorial {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size

        // Base case.
        var contains = 0
        for (i in 0 until n) if (nums[i] == 1) {
            contains++
            break
        }
        if (contains == 0) return 1

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this conversion nums will contain
        // only positive numbers.
        for (i in 0 until n) if (nums[i] <= 0 || nums[i] > n) nums[i] = 1

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (i in 0 until n) {
            val a = Math.abs(nums[i])
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n) {
                nums[0] = -Math.abs(nums[0])
            } else {
                nums[a] = -Math.abs(nums[a])
            }
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (i in 1 until n) {
            if (nums[i] > 0) {
                return i
            }
        }
        return if (nums[0] > 0) {
            n
        } else {
            n + 1
        }
    }
}