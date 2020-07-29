package problems.no15650

/**
 * ProblemNo15650.kt
 * N & M 2
 * https://www.acmicpc.net/problem/15650
 */

import NAndM
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nAndM = NAndM(range, maxDepth)

    nAndM.printCombination(0, 1)
}
