/**
 * ProblemNo11054.kt
 * Longest Bitonic Subsequence
 * https://www.acmicpc.net/problem/11053
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 2)
    val subsequence = Subsequence(sequence)

    sequence[0] = 0
    sequence[sequence.size - 1] = 0

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    println(subsequence.getMaxBitonicLength())
}
