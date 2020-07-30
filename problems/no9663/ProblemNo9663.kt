package problems.no9663

/**
 * ProblemNo9663.kt
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */

import java.util.*

class NQueen(private val size: Int) {
    private var numPlacingCase = 0
    private var promisingQueenColumn = Array(size) { -1 }

    private fun countPlacingCase(row: Int, startingColumn: Int) {
        if (row == size - 1) {
            numPlacingCase++
        } else {
            for (i in 0 until size) {
                promisingQueenColumn[row + 1] = i

                if (isPointPromising(Point(row + 1, i))) {
                    countPlacingCase(row + 1, startingColumn)
                } else {
                    promisingQueenColumn[row + 1] = -1
                }
            }
        }

        promisingQueenColumn[row] = -1
    }

    private fun isPointPromising(point: Point): Boolean {
        for (i in 0 until point.row) {
            if (point.row == i ||
                point.column == promisingQueenColumn[i] ||
                kotlin.math.abs(point.row - i) == kotlin.math.abs(point.column - promisingQueenColumn[i])
            ) {
                return false
            }
        }

        return true
    }

    fun solve(): Int {
        for (i in 0 until size) {
            promisingQueenColumn[0] = i

            countPlacingCase(0, i)
        }

        return numPlacingCase
    }
}

data class Point(val row: Int, val column: Int)

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val nQueen = NQueen(size)

    print(nQueen.solve())
    println()
}
