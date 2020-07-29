package problems.no2156

/**
 * ProblemNo2156.kt
 * Wine Tasting
 * https://www.acmicpc.net/problem/2156
 */

import java.util.*

class WineTaster(private val amount: IntArray) {
    private var memoMaxTotalAmountAt = IntArray(10000)

    fun getMaxTotalAmountAt(glassNo: Int): Int { // Check if to go dynamic
        if (memoMaxTotalAmountAt[glassNo] == 0) {
            when (glassNo) {
                0 -> memoMaxTotalAmountAt[glassNo] = amount[glassNo]
                1 -> memoMaxTotalAmountAt[glassNo] = amount[glassNo] + amount[glassNo - 1]
                2 -> memoMaxTotalAmountAt[glassNo] = maxOf(
                    amount[glassNo] + amount[glassNo - 1],
                    amount[glassNo] + getMaxTotalAmountAt(glassNo - 2),
                    getMaxTotalAmountAt(glassNo - 1)
                )
                else -> memoMaxTotalAmountAt[glassNo] = maxOf(
                    amount[glassNo] + amount[glassNo - 1] + getMaxTotalAmountAt(glassNo - 3),
                    amount[glassNo] + getMaxTotalAmountAt(glassNo - 2),
                    getMaxTotalAmountAt(glassNo - 1)
                )
            }
        }

        return memoMaxTotalAmountAt[glassNo]
    }
}

fun main() = with(Scanner(System.`in`)) {
    val numGlass = nextInt()
    val wineAmount = IntArray(numGlass) { nextInt() }
    val wineTaster = WineTaster(wineAmount)

    println(wineTaster.getMaxTotalAmountAt(numGlass - 1))
}
