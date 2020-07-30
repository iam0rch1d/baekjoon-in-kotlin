package problems.no11722

/**
 * ProblemNo11722.kt
 * Longest Decreasing Subsequence
 * https://www.acmicpc.net/problem/11722
 */

import Subsequence
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val subsequence = Subsequence(sequence)

    sequence[sequence.size - 1] = 0

    for (i in 0 until size) {
        sequence[i] = nextInt()
    }

    println(subsequence.calculateMaxDecreaseLength())
}
