/**
 * ProblemNo11053.kt
 * Longest Increasing Subsequence
 * https://www.acmicpc.net/problem/11053
 */

import java.util.Scanner


class Subsequence(private val sequence: IntArray) {
    var memoMaxIncreaseLengthAt = IntArray(sequence.size)

    fun getMaxIncreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] < sequence[i] && memoMaxIncreaseLengthAt[i] < memoMaxIncreaseLengthAt[j] + 1) {
                    memoMaxIncreaseLengthAt[i] = memoMaxIncreaseLengthAt[j] + 1
                }
            }
        }

        return memoMaxIncreaseLengthAt.max()!!
    }
}


fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val sequence = IntArray(size + 1)
    val subsequence = Subsequence(sequence)

    sequence[0] = 0

    for (i in 1..size) {
        sequence[i] = nextInt()
    }

    println(subsequence.getMaxIncreaseLength())
}
