/**
 * ProblemNo12865.kt
 * Knapsack
 * https://www.acmicpc.net/problem/12865
 */

import java.util.Scanner


class Knapsack(private val numItem: Int, private val strength: Int, private val item: Array<Item>) {
    private var memoTotalTakenValue = Array(numItem + 1) { IntArray(strength + 1) }

    fun getMaxTotalTakenValue(): Int {
        for (i in 1..numItem) {
            for (j in 1..strength) {
                if (item[i - 1].load <= j) {
                    memoTotalTakenValue[i][j] = maxOf(
                        item[i - 1].value + memoTotalTakenValue[i - 1][j - item[i - 1].load],
                        memoTotalTakenValue[i - 1][j]
                    )
                } else {
                    memoTotalTakenValue[i][j] = memoTotalTakenValue[i - 1][j]
                }
            }
        }

        return memoTotalTakenValue[numItem][strength]
    }
}


data class Item(val load: Int, val value: Int)


fun main() = with(Scanner(System.`in`)) {
    val numItem = nextInt()
    val strength = nextInt()
    val item = Array(numItem) { Item(nextInt(), nextInt()) }
    val knapsack = Knapsack(numItem, strength, item)

    println(knapsack.getMaxTotalTakenValue())
}
