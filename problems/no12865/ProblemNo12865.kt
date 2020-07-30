package problems.no12865

/**
 * ProblemNo12865.kt
 * problems.no12865.Knapsack
 * https://www.acmicpc.net/problem/12865
 */

import java.util.*

class Knapsack(private val numItem: Int, private val strength: Int, private val item: Array<Item>) {
    private var totalValue = Array(numItem + 1) { IntArray(strength + 1) }

    fun calculateMaxTotalValue(): Int {
        for (i in 1..numItem) {
            for (j in 1..strength) {
                if (item[i - 1].load <= j) {
                    totalValue[i][j] = maxOf(
                        item[i - 1].value + totalValue[i - 1][j - item[i - 1].load],
                        totalValue[i - 1][j]
                    )
                } else {
                    totalValue[i][j] = totalValue[i - 1][j]
                }
            }
        }

        return totalValue[numItem][strength]
    }
}

data class Item(val load: Int, val value: Int)

fun main() = with(Scanner(System.`in`)) {
    val numItem = nextInt()
    val strength = nextInt()
    val item = Array(numItem) { Item(nextInt(), nextInt()) }
    val knapsack = Knapsack(numItem, strength, item)

    println(knapsack.calculateMaxTotalValue())
}
