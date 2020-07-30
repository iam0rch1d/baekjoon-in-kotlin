package problems.no1912

/**
 * ProblemNo1912.kt
 * Continuous Sum
 * https://www.acmicpc.net/problem/1912
 */

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val maxContinuousSum = IntArray(size + 1)

    sequence[0] = 0

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    maxContinuousSum[0] = -1001

    for (i in 1..size) {
        maxContinuousSum[i] = maxOf(maxContinuousSum[i - 1] + sequence[i], sequence[i])
    }

    println(maxContinuousSum.max()!!)
}
