package baekjoon.kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n) {
        IntArray(3)
    }

    var st = StringTokenizer(readLine(), " ")
    dp[0][0] = st.nextToken().toInt()
    dp[0][1] = st.nextToken().toInt()
    dp[0][2] = st.nextToken().toInt()

    repeat(n - 1) { i ->
        st = StringTokenizer(readLine(), " ")
        dp[i + 1][0] = min(dp[i][1], dp[i][2]) + st.nextToken().toInt()
        dp[i + 1][1] = min(dp[i][0], dp[i][2]) + st.nextToken().toInt()
        dp[i + 1][2] = min(dp[i][0], dp[i][1]) + st.nextToken().toInt()
    }

    print(min(dp[n - 1][0], min(dp[n - 1][1], dp[n - 1][2])))
}

