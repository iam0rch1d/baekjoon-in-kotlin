/**
 * ProblemNo5543.kt
 * Sanggeunnalds
 * https://www.acmicpc.net/problem/5543
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val cost = Array(5) { nextInt() }
    val costBurgerMin = minOf(cost[0], cost[1], cost[2])
    val costBeverageMin = minOf(cost[3], cost[4])
    val costDiscount = 50

    println("${costBurgerMin + costBeverageMin - costDiscount}")
}
