/**
 * ProblemNo1149.kt
 * RGB Street
 * https://www.acmicpc.net/problem/1149
 */

import java.util.Scanner

const val MAX_COST_TOTAL_SUM: Int = 1000000

fun main() = with(Scanner(System.`in`)) {
    val numStreet = nextInt()
    val cost = Array(numStreet) { IntArray(3) }
    val minCostPartialSum = Array(numStreet) { IntArray(3) }
    var minCostTotalSum: Int = MAX_COST_TOTAL_SUM

    // Scan each cost
    for (i in 0 until numStreet) {
        for (j in 0..2) {
            cost[i][j] = nextInt()

            if (i == 0) {
                minCostPartialSum[i][j] = cost[i][j]
            }
        }
    }

    // Memoization
    for (i in 1 until numStreet) {
        for (j in 0..2) {
            minCostPartialSum[i][j] = minOf(
                minCostPartialSum[i - 1][(j + 1) % 3], // Next color
                minCostPartialSum[i - 1][(j + 2) % 3] // Next after next color
            ) + cost[i][j]
        }
    }

    // Get minimum cost total sum
    for (i in 0..2) {
        if (minCostPartialSum[numStreet - 1][i] <= minCostTotalSum) {
            minCostTotalSum = minCostPartialSum[numStreet - 1][i]
        }
    }

    println(minCostTotalSum)
}
