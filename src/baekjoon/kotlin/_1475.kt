package baekjoon.kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()

    val countArr = Array(10) { i -> 0 }

    var max = 0
    var sixAndNineCount = 0
    for (c in n.toCharArray()) {
        val num = Character.getNumericValue(c)
        countArr[num] += 1
        if (num == 6 || num == 9) {
            sixAndNineCount += 1
            max = max(max, sixAndNineCount / 2 + sixAndNineCount % 2)
        } else {
            max = max(max, countArr[num])
        }
    }

    println(max)
}