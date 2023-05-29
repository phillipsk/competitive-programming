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
    ReverseString().printReverse(charArrayOf('h', 'e', 'l', 'l', 'o'))
}