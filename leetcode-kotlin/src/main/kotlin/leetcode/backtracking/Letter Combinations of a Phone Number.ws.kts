val phoneNums = mapOf(
    "2" to "abc", "3" to "def", "4" to "ghi",
    "5" to "jkl", "6" to "mno", "7" to "pqrs",
    "8" to "tuv", "9" to "wxyz", "1" to ""
)
letterCombinations("2345")

fun letterCombinations(digits: String): List<String> {
    val list = mutableListOf<String>()
    digits.forEachIndexed { index, c -> // c = abc
        val lhs = phoneNums[c.toString()] // abc
//        val next = index + 1
//        if (next <= digits.length)
        val rhs = phoneNums[digits.elementAt(index + 1).toString()] // def
        lhs?.forEach { ll ->
            rhs?.forEach { rr ->
                list.add(ll.toString() + rr.toString())
            }
        }
    }
    return list
}
//        s?.let { it1 -> list.add(it1) }
/*Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]*/


/*var c: Char = 'a'
map[1] = ""

while (c <= 'z'){
    for (i in 2..9){
        when(i){
            7,9 -> {
                map[i] =
            }
            else -> {

            }
        }
    }
    c++
}*/
