package problems.no14002

/**
 * ProblemNo14002.kt
 * Longest Increasing Subsequence 4
 * https://www.acmicpc.net/problem/14002
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

    println(subsequence.getMaxIncreaseLength())
    subsequence.printMaxIncrease()
}
