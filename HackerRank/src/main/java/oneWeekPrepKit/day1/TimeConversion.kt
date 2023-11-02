package src.main.java.oneWeekPrepKit.day1

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

const val SUFFIX_INDEX = 2
const val DELIMITER = ":"

enum class TimeFormat(val suffix: String) {
    AM("AM"),
    PM("PM")
}


fun timeConversion(s: String): String {
    // Write your code here
    val o = s.split(DELIMITER).toMutableList()

    when {
        o[SUFFIX_INDEX].contains(TimeFormat.AM.suffix) -> {
            o[2] = o[2].removeSuffix(TimeFormat.AM.suffix)
            if (o[0] == "12") {
                o[0] = "00"
            }
        }

        o[SUFFIX_INDEX].contains(TimeFormat.PM.suffix) -> {
            o[2] = o[2].removeSuffix(TimeFormat.PM.suffix)
            if (o[0] != "12") {
                o[0] = (o[0].toLong() + 12).toString()
            }
        }
    }

    return o.joinToString(DELIMITER)
}

fun main(args: Array<String>) {
    val s = arrayOf("12:01:00PM", "12:01:00AM", "07:05:45PM")
    s.forEach {
        println(timeConversion(it))
    }

}
