package leetcode.heaps

import java.util.*

class MedianFinder {

    //val queue = PriorityQueue<Int> { a, b -> b - a }
    val max = PriorityQueue<Int>()
    val min = PriorityQueue<Int>()

    fun addNum(num: Int) {
        max.peek().also {
            if (it == null || num > it)
                max.add(num)
            else min.add(num)
        }
    }

    fun findMedian(): Double {
        return 0.00
    }

}

fun main() {
    val m = MedianFinder()

    val a = arrayOf(6, 2, 3, 9, 1, 4)

    a.forEach {
        m.addNum(it)
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */