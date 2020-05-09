/**
 * ProblemNo2156.kt
 * Wine Tasting
 * https://www.acmicpc.net/problem/2156
 */

import java.util.Scanner


class WineTaster(private val amount: IntArray) {
    private var memoMaxTotalAmountAt = IntArray(10000)

    fun getMaxTotalAmountAt(glassNo: Int): Int {
        if (memoMaxTotalAmountAt[glassNo] != 0) {
            return memoMaxTotalAmountAt[glassNo]
        } else when (glassNo) {
            0 -> memoMaxTotalAmountAt[glassNo] = amount[0]
            1 -> memoMaxTotalAmountAt[glassNo] = amount[1] + amount[0]
            2 -> memoMaxTotalAmountAt[glassNo] = maxOf(
                amount[2] + amount[1],
                amount[2] + amount[0],
                getMaxTotalAmountAt(1)
            )
            else -> memoMaxTotalAmountAt[glassNo] = maxOf(
                amount[glassNo] + amount[glassNo - 1] + getMaxTotalAmountAt(glassNo - 3),
                amount[glassNo] + getMaxTotalAmountAt(glassNo - 2),
                getMaxTotalAmountAt(glassNo - 1)
            )
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
