package problems.no2156

/**
 * ProblemNo2156.kt
 * Wine Tasting
 * https://www.acmicpc.net/problem/2156
 */

import java.util.*

class WineTaster(private val amount: IntArray) {
    private var maxTotalAmount = IntArray(10000)

    fun getMaxTotalAmountAt(glassNo: Int): Int { // Check if to go dynamic
        if (maxTotalAmount[glassNo] == 0) {
            when (glassNo) {
                0 -> maxTotalAmount[glassNo] = amount[glassNo]
                1 -> maxTotalAmount[glassNo] = amount[glassNo] + amount[glassNo - 1]
                2 -> maxTotalAmount[glassNo] = maxOf(
                    amount[glassNo] + amount[glassNo - 1],
                    amount[glassNo] + getMaxTotalAmountAt(glassNo - 2),
                    getMaxTotalAmountAt(glassNo - 1)
                )
                else -> maxTotalAmount[glassNo] = maxOf(
                    amount[glassNo] + amount[glassNo - 1] + getMaxTotalAmountAt(glassNo - 3),
                    amount[glassNo] + getMaxTotalAmountAt(glassNo - 2),
                    getMaxTotalAmountAt(glassNo - 1)
                )
            }
        }

        return maxTotalAmount[glassNo]
    }
}

fun main() = with(Scanner(System.`in`)) {
    val numGlass = nextInt()
    val wineAmount = IntArray(numGlass) { nextInt() }
    val wineTaster = WineTaster(wineAmount)

    println(wineTaster.getMaxTotalAmountAt(numGlass - 1))
}
