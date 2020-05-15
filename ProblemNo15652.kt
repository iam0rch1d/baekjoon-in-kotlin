/**
 * ProblemNo15652.kt
 * N & M 4
 * https://www.acmicpc.net/problem/15652
 */

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nm = NAndM(range, maxDepth)

    nm.solveProblem(4)
}
