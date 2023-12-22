package leetcode.heaps

import java.util.*

val a = arrayOf(6, 2, 3, 9, 1, 4)
//val queue = PriorityQueue<Int> { a, b -> b - a }
val min = PriorityQueue<Int>()
val max = PriorityQueue<Int>(Collections.reverseOrder())
max.addAll(a)
min.addAll(a)

max.peek()
max.poll()
max.peek()


min.peek()
min.poll()



