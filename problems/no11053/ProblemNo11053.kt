package problems.no11053

/**
 * ProblemNo11053.kt
 * Longest Increasing Subsequence
 * https://www.acmicpc.net/problem/11053
 */

import Subsequence
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val subsequence = Subsequence(sequence)

    sequence[0] = 0

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    println(subsequence.calculateMaxIncreaseLength())
}
