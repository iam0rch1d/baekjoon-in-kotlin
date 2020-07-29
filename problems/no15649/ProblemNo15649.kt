package problems.no15649

/**
 * ProblemNo15649.kt
 * N & M
 * https://www.acmicpc.net/problem/15649
 */

import NAndM
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nAndM = NAndM(range, maxDepth)

    nAndM.printPermutation(0)
}
