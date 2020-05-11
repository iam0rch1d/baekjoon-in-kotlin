/**
 * ProblemNo1912.kt
 * Continuous Sum
 * https://www.acmicpc.net/problem/1912
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val memoMaxContinuousSum = IntArray(size + 1)

    sequence[0] = 0

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    memoMaxContinuousSum[0] = -1001

    for (i in 1..size) {
        memoMaxContinuousSum[i] = maxOf(memoMaxContinuousSum[i - 1] + sequence[i], sequence[i])
    }

    println(memoMaxContinuousSum.max()!!)
}
