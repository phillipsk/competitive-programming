package backtracking

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        helper(s, 0, s.lastIndex)

    }

    private fun helper(s: CharArray, left: Int, right: Int) {
        if (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            helper(s, left + 1, right - 1)
        }
    }
}

fun main() {
    println(ReverseString().reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
}