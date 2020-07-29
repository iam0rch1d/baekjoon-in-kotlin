package problems.no2579

/**
 * ProblemNo2579.kt
 * Stair Up
 * https://www.acmicpc.net/problem/2579
 */

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val score = Array(size) { nextInt() }
    val maxScorePartialSum = IntArray(size)

    if (size >= 1) {
        maxScorePartialSum[0] = score[0]
    }

    if (size >= 2) {
        maxScorePartialSum[1] = score[0] + score[1]
    }

    if (size >= 3) {
        maxScorePartialSum[2] = maxOf(score[1], score[0]) + score[2]
    }

    if (size >= 4) {
        for (i in 3 until size) {
            maxScorePartialSum[i] = maxOf(
                score[i - 1] + maxScorePartialSum[i - 3],
                maxScorePartialSum[i - 2]
            ) + score[i]
        }
    }

    println(maxScorePartialSum[size - 1])
}
