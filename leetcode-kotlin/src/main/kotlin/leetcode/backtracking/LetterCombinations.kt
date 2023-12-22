package leetcode.backtracking

class Solution {
    private val phoneNums = mapOf(
        "2" to "abc", "3" to "def", "4" to "ghi",
        "5" to "jkl", "6" to "mno", "7" to "pqrs",
        "8" to "tuv", "9" to "wxyz", "1" to ""
    )

    fun letterCombinations(digits: String): List<String> {
        val list = mutableListOf<String>()
        digits.forEachIndexed { index, c -> // c = abc
            val lhs = phoneNums[c.toString()] // abc
            if (digits.length == 1) {
                lhs.toString().forEach {
                    list.add(it.toString())
                }
            } else {
                var rhs: String? = null
                val next = index + 1
                if (next <= digits.lastIndex) {
                    rhs = phoneNums[digits.elementAt(next).toString()] // def
                }
                lhs?.forEach { ll ->
                    rhs?.forEach { rr ->
                        list.add(ll.toString() + rr.toString())
                    }
                }
            }
        }
        return list
    }
}

class SolutionGH {
    private val mm: Map<Char, String> = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        var res = mutableListOf<String>()
        if (digits.length == 0) return res
        var word: String = ""

        fun dfs(cur: Int) {
            if (cur >= digits.length) {
                res.add(word)
                return;
            }
            val s: String? = mm[digits[cur]]
            for (i in s!!) {
                word += i
                dfs(cur + 1)
                word = word.substring(0, word.length - 1)
            }
        }
        dfs(0)
        return res
    }
}

class SolutionDevCommunity {
    private val map: Map<Char, String> = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> { // 2349
        val res = mutableListOf<String>()
        if (digits.isEmpty()) return res

        fun backtrack(i: Int, curStr: String) {
            if (curStr.length == digits.length) {
                res.add(curStr)
                return
            }

            map[digits[i]]?.forEach {
                val nextI = i + 1
                val nextCur = curStr + it
                backtrack(nextI, nextCur)
            }
        }
        backtrack(0, "")
        return res
    }
}

fun main() {
    /*Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]*/

//    println(SolutionGH().letterCombinations("2349"))
    println(SolutionDevCommunity().letterCombinations("2349"))

    /*    println(Solution().letterCombinations("2"))
        println(Solution().letterCombinations("2345"))
        println(Solution().letterCombinations("23"))
        Solution().letterCombinations("23")*/
}



