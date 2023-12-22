package leetcode

import kotlin.math.abs
import kotlin.math.log10

class Solution {
    fun isPalindrome(x: Int): Boolean {

        if (x < 0 || (x % 10 == 0 && x != 0)) return false

        var r = 0
        var x1 = x

        while (x1 > r) {
            r = r * 10 + (x1 % 10)
//            r.times(10).plus((x.mod(10)))
            x1 = x1.div(10)
        }

        return if (x1 == r || x1 == r / 10) {
            true.also { println("$x isPalindrome") }
        } else false.also { println("$x is NOT a Palindrome") }

        /*        val s = x.toString()
                x.toString().forEachIndexed { index, c ->
                    val c1 = s[s.lastIndex - index]
                    if (c != c1) return false.also { println("$x is NOT a Palindrome") }
                }
                return true.also { println("$x isPalindrome") }*/


    }
}

fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}

fun main() {
    Solution().isPalindrome(x = 121)
    Solution().isPalindrome(x = 1000021)
    Solution().isPalindrome(x = 1211)
}

