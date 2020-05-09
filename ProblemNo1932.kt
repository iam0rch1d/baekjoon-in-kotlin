/**
 * ProblemNo1932.kt
 * Integer Triangle
 * https://www.acmicpc.net/problem/1932
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val triangleSize = nextInt()
    val triangleSizeIndex = triangleSize - 1
    val triangle = Array(triangleSize) { IntArray(triangleSize) }
    val maxTrianglePartialSum = Array(triangleSize) { IntArray(triangleSize) }
    var maxTriangleTotalSum = 0
    var previousTriangleLayer: Int

    // Scan triangle
    for (i in 0 until triangleSize) {
        for (j in 0..i) {
            triangle[i][j] = nextInt()

            if (i == 0) {
                maxTrianglePartialSum[i][j] = triangle[i][j]
            }
        }
    }

    // Memoization
    for (i in 1 until triangleSize) {
        previousTriangleLayer = i - 1;

        for (j in 0..i) {
            when (j) {
                0 -> maxTrianglePartialSum[i][j] = maxTrianglePartialSum[previousTriangleLayer][j] + triangle[i][j]
                else -> maxTrianglePartialSum[i][j] = maxOf(
                    maxTrianglePartialSum[previousTriangleLayer][j - 1],
                    maxTrianglePartialSum[previousTriangleLayer][j]
                ) + triangle[i][j]
            }
        }
    }

    // Get maximum triangle total sum
    for (i in 0 until triangleSize) {
        if (maxTrianglePartialSum[triangleSizeIndex][i] >= maxTriangleTotalSum) {
            maxTriangleTotalSum = maxTrianglePartialSum[triangleSizeIndex][i]
        }
    }

    println(maxTriangleTotalSum)
}
