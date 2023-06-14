package backtracking

class ReverseString {

    fun printReverse(str: CharArray) {
        helper(0, str)
    }

    private fun helper(index: Int, str: CharArray?) {
        if (str == null || index >= str.size) {
            return
        }
        helper(index + 1, str)
        print(str[index])
    }
}

fun main() {
//    println(ReverseString().printReverse(charArrayOf('h', 'e', 'l', 'l', 'o')))
//    ReverseString().printReverse(charArrayOf('h', 'e', 'l', 'l', 'o'))
    EditorialSolution().reverseString(charArrayOf('h', 'e', 'l','j', 'l', 'o'))
}
internal class EditorialSolution {
    private fun helper(s: CharArray, left: Int, right: Int) {
        var left = left
        var right = right
        if (left >= right) return
        val tmp = s[left]
        s[left++] = s[right]
        s[right--] = tmp
        helper(s, left, right)
    }

    fun reverseString(s: CharArray) {
        helper(s, 0, s.size - 1)
    }
}