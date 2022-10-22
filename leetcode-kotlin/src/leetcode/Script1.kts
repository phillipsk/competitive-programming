import jdk.nashorn.internal.runtime.JSType.toDouble
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.log10

val x = 121
val f = x.mod(10)
f
val digits = x.toDouble()
digits
(log10(digits)+1).absoluteValue
abs(log10(digits))
log10(abs(x.toDouble())).toInt() + 1


//fun Int.leetcode.length() = when(this) {
//    0 -> 1
//    else -> log10(abs(toDouble())).toInt() + 1
//}
//
//leetcode.Solution().isPalindrome(x)

