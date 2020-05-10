/**
 * ProblemNo11722.kt
 * Longest Decreasing Subsequence
 * https://www.acmicpc.net/problem/11722
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val subsequence = Subsequence(sequence)

    sequence[0] = Int.MAX_VALUE

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    println(subsequence.getMaxDecreaseLength())
}
