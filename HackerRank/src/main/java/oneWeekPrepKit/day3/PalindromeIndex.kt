/*
 * Complete the 'palindromeIndex' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun palindromeIndex(s: String): Int {
    // Write your code here
    // only lowercase letters
//    return -1 if solution cannot be found

    var isPalindrome = checkPalindrome(s)
    return if (isPalindrome) 0 else {
        var rh = s.lastIndex - 1
        for (i in 1 until rh) {
//        print("i :: $i  rh ::$rh \n")
//            s.substring(i + 1, rh - 1)
            isPalindrome = checkPalindrome(s.substring(i, rh))
//            rh--
            if (isPalindrome) return 0
        }
        -1
    }

}

fun checkPalindrome(s: String): Boolean {
    var isPalindrome = false
    var rh = s.lastIndex
    for (i in s.indices) {
//        print("i :: $i  rh ::$rh \n")
        isPalindrome = s[i] == s[rh]
        rh--
    }
    return isPalindrome
}

fun main(args: Array<String>) {
    arrayOf("aaab", "baa", "aaa").forEach {
        println(palindromeIndex(it))
    }
}
