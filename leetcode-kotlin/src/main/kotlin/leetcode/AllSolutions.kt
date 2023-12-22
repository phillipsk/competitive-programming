package leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

fun isAnagram(s: String, t: String): Boolean {
    if (s.toLowerCase().toCharArray().sorted()
        == t.toLowerCase().toCharArray().sorted()
    ) {
        return true
    }
    return false
}

fun groupAnagramsII(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) {
        return emptyList()
    }

    val hashMap = hashMapOf<String, MutableList<String>>()

    for (i in 0 until strs.size) {
        val charArray = strs[i].toCharArray()
        charArray.sort()
        val sortedWord = String(charArray)
        if (hashMap.containsKey(sortedWord)) {
            hashMap[sortedWord]?.let {
                it.add(strs[i])
                hashMap[sortedWord] = it
            }
        } else {
            val list = mutableListOf<String>()
            list.add(strs[i])
            hashMap[sortedWord] = list
        }
    }
    val list = mutableListOf<List<String>>()
    hashMap.values.forEach {
        list.add(it)
    }
    return list
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = strs.groupBy { s ->
        s.toCharArray().sorted().toString()
    }
    return map.values.toList()
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var map = hashMapOf<Int, Int>()
    for ((index, value) in nums.withIndex()) {
        var a = target - value
        if (map.containsKey(a)) {
            return intArrayOf(index, map.get(a)!!)
        }
        map.put(value, index)
    }
    return intArrayOf()
}

fun twoSumPointers(numbers: IntArray, target: Int): IntArray {
    if (numbers == null || numbers.size == 0) return IntArray(0)
    var (i, j) = intArrayOf(0, numbers.size - 1)
    while (i < j) {
        var sum = numbers[i] + numbers[j]
        if (sum == target) return intArrayOf(i + 1, j + 1)
        else if (sum < target) i++
        else j--
    }
    return IntArray(0)
}

fun maximumGap(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size < 2) return 0
    nums.sort()
    var maxGap = 0
    for (i in nums.indices) {
        if (i == nums.lastIndex) return maxGap
        var tempGap = nums[i + 1] - nums[i]
        if (tempGap > maxGap) maxGap = tempGap
    }
    return maxGap
}

fun reorganizeStringPQ(S: String): String {
    val K = 2
    val N = S.length
    val ans = StringBuilder()
    val freq = IntArray(26)
    val pq = PriorityQueue { a: IntArray, b: IntArray -> b[1] - a[1] } // char -> freq
    val waitingQ: Queue<IntArray> = LinkedList()
    for (ch in S) {
        freq[ch - 'a']++
    }
    for (i in 0 until 26) {
        if (freq[i] > 0) {
            pq.offer(intArrayOf(i, freq[i]))
        }
    }
    while (pq.isNotEmpty()) {
        val current = pq.poll()
        ans.append((current[0] + 97).toChar())
        current[1]--
        waitingQ.add(current)
        if (waitingQ.size == K) {
            val recent = waitingQ.poll()
            if (recent[1] > 0) {
                pq.offer(recent)
            }
        }
    }
    return if (ans.length == N) {
        ans.toString()
    } else {
        ""
    }
}

fun reorganizeString(s: String): String {
    //map to keep track of the number of times a letter appears
    val frequencyMap = hashMapOf<Char, Int>()
    //stack that holds every letter that isnt the one that appears the most (will explain more below)
    val lStack = Stack<Char>()
    val answer = StringBuilder()

    //these two variables keep track of the letter that appears the most and its count
    var mostCommonLetter = s[0]
    var mostCommonLetterCount = 0

    //iterate through the string and add each letters frequency to our frequency map
    s.forEach {
        val count = frequencyMap.getOrDefault(it, 0) + 1
        frequencyMap[it] = count
        //if a letter appears more times than half the length of the entire string then reorganization is not possible
        // TODO: to me KP, this statement expresses if a majority is reached, the task is impossible
        if (count > Math.ceil(s.length / 2.0)) return ""

        //this is how we keep count of the most common letter and its count
        if (count > mostCommonLetterCount) {
            mostCommonLetterCount = count
            mostCommonLetter = it
        }
    }
    //now we want to remove the most common letter
    //this isnt necessary but it reduces the amount of times we need to iterate our frequency map below
    frequencyMap.remove(mostCommonLetter)

    //now we want to add every remaining letter into our stack in alternating order (in order to avoid common letters next to one another)
    //we use isMapEmpty to see if every item in the hashmap has a count of 0
    //every time we enter the while loop we set this boolean to true then when iterating the hashmap if any value is greater than 0 then it sets this to false so we iterate again
    var isMapEmpty = false
    while (!isMapEmpty) {
        isMapEmpty = true
        frequencyMap.forEach { (it, count) ->
            if (it == mostCommonLetter) return@forEach
            if (count > 0) {
                //add letter to the stack
                lStack.push(it)
                frequencyMap[it] = count - 1
                isMapEmpty = false
            }
        }

    }
    //the idea here is to add the mostCommonLetter to every other position mostCommonLetterCount times
    // lets look at aaaaabbbbcccdde
    // first we want this a _ a _ a _ a _ a _ _ _ _ _ _
    // next we want to pop the stack into the remaining blank spaces so we get
    // a b a c a b a d a c b e d c b
    // in order to do this in one loop we keep track of maxIndex which is the index of where the max value should go
    // when index == maxIndex we add mostCommonLetter to our string and maxIndex = maxIndex + 2
    // otherwise we get the next letter from our stack

    var maxIndex = 0
    for (index in s.indices) {
        if (index == maxIndex && mostCommonLetterCount > 0) {
            mostCommonLetterCount--
            answer.append(mostCommonLetter)
            maxIndex += 2
        } else {
            answer.append(lStack.pop())
        }
    }

    return answer.toString()

}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    if (target == 0 || position.isEmpty() || speed.isEmpty()) return 0
    val n = position.size
    var time = DoubleArray(n)
    var distance = IntArray(n)
    var map = hashMapOf<Int, Double>()
    for (i in 0 until n) {
        distance[i] = target - position[i]
        time[i] = distance[i].toDouble() / speed[i].toDouble()
        map.put(distance[i], time[i])
    }
    distance.sort()
    var rTimeL = arrayListOf<Double>()
    for (i in 0 until n) {
        var t = map[distance[i]]
        var m = rTimeL.size
        if (m == 0 || t!! > rTimeL[m - 1]) { // this expression filters unique records
            rTimeL.add(t!!)
        }
    }
    return rTimeL.size
}

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
//Input: nums = [1,2,3,4], n = 4, left = 1, right = 5 Output: 13
    var out = IntArray(n * (n + 1) / 2)
//    var out = IntArray(n *2)
    var mod = 1_000_000_007
    var sum = 0L
    var sums = ArrayList<Long>();

    run {
        var i = 0
        var sum = 0
        while (i < n) {
            for (j in i until n) {
                sum += nums[j]
                sums.add(sum.toLong())
            }
            ++i
            sum = 0
        }
    }

    sums.sort()
    var nleft = left - 1
    var nright = right - 1
    for (i in 0 until sums.size) {
        if (i in nleft..nright) {
            sum += sums[i]
        }
    }
    return sum.toInt() % mod
}

fun permCheck(A: IntArray): Int {
    A.sort()
//    for (i in 0..A.size step 2) {
    for (i in A.indices) {
        var t = i
        if (abs(i+1 - i) != 1) return 0
    }
    return 1
}

fun main() {
    check(isAnagram("anagram", "nagaram"))
    check(!isAnagram("anagramzz", "nagaram"))
    var strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    var out = arrayOf<List<String>>(
        arrayListOf("bat"),
        arrayListOf("nat", "tan"), arrayListOf("ate", "eat", "tea")
    )
//  TODO: compare arrayLists of Strings, regardless of structure, order, only compare elements exist
//    check(out == groupAnagrams(strs))
//    check(out.contentEquals(groupAnagrams(strs)))
//    check(out.contentDeepEquals(groupAnagrams(strs)))
    val list = arrayOf<String>()
    var s = groupAnagrams(list)
//    check(list==groupAnagrams(list))

    var nums = intArrayOf(2, 7, 11, 15)
    var target = 9
//    caller(nums, target)
//    print(twoSum(nums, target).contentToString())
    check("[1, 0]" == twoSum(nums, target).contentToString())
    check("[1, 2]" == twoSumPointers(nums, target).contentToString())

    nums = intArrayOf(3, 6, 9, 1)
    check(3 == maximumGap(nums))
    nums = intArrayOf(10)
    check(0 == maximumGap(nums))

    check("aba" == reorganizeString("aab"))

    check(3 == carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3)))
    check(1 == carFleet(10, intArrayOf(2, 4), intArrayOf(3, 2)))

//    TODO: finish #1508. Range Sum of Sorted Subarray Sums
    check(13 == rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 5))
    check(6 == rangeSum(intArrayOf(1, 2, 3, 4), 4, 3, 4))
    check(50 == rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 10))

    check(1 == permCheck(intArrayOf(4, 3, 2, 1)))
    check(0 == permCheck(intArrayOf(4, 1, 3)))
}



