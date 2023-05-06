package arrays

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var j = 0
        for (i in 0 until nums.size) {
            if (nums[i] == `val`) {
                j = i
                while (j < nums.size && nums[j] == nums[i]) {
                    j++
                }
                if (j < nums.size) {
                    val t = nums[i]
                    nums[i] = nums[j]
                    nums[j] = t
                }
            }
        }
        var counter = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                counter++
            }
        }

        return counter
    }
}

fun main() {
    println(RemoveElement().removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(RemoveElement().removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}