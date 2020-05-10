/**
 * ProblemNo2565.kt
 * Electric Wire
 * https://www.acmicpc.net/problem/2565
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val numWire = nextInt()
    val connection = Array(numWire) { IntArray(2) }
    val connectionSequence = IntArray(501)
    val subsequence = Subsequence(connectionSequence)

    for (i in 0 until numWire) {
        for (j in 0..1) {
            connection[i][j] = nextInt()
        }

        connectionSequence[connection[i][0]] = connection[i][1]
    }

    println(numWire - subsequence.getMaxIncreaseLength())
}
