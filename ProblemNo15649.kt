/**
 * ProblemNo15649.kt
 * N & M
 * https://www.acmicpc.net/problem/15649
 */

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val range = nextInt() // N
    val maxDepth = nextInt() // M
    val nm = NAndM(range, maxDepth)

    nm.solveProblem(1)
}
