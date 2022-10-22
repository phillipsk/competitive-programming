import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.log10

val x = 1000021
x.mod(10) // last
x.div(10) // drop last
x * 10 + x % 10

val r = x.mod(10)
r
x

val f = x.mod(10)
f
val digits = x.toDouble()
digits
(log10(digits) + 1).absoluteValue
abs(log10(digits))
log10(abs(x.toDouble())).toInt() + 1
x.length()
//val s = x.toString().splitToSequence()
//s[1]
x.toString()[0]

x.toString().first().equals(x.toString().last())
x.mod(2).equals(0) == false



fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}