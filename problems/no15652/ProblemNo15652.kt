package problems.no15652

/**
 * ProblemNo15652.kt
 * N & M 4
 * https://www.acmicpc.net/problem/15652
 */

import NAndM
import java.util.*

fun main(): Unit = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nAndM = NAndM(range, maxDepth)

    nAndM.printRepetitiveCombination(0, 1)
}
