package problems.no15651

/**
 * ProblemNo15651.kt
 * N & M 3
 * https://www.acmicpc.net/problem/15651
 */

import NAndM
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nAndM = NAndM(range, maxDepth)

    nAndM.printRepetitivePermutation(0)
}
