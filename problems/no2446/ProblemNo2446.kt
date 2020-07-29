package problems.no2446

/**
 * ProblemNo2446.kt
 * Star Picture 9
 * https://www.acmicpc.net/problem/2446
 */

import java.util.*

fun printStarLine(size: Int, i: Int) {
    for (j in 1..i) {
        print(" ")
    }

    for (j in 1 until 2 * (size - i)) {
        print("*")
    }

    println()
}

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()

    for (i in 0 until size) {
        printStarLine(size, i)
    }

    for (i in (size - 2) downTo 0) {
        printStarLine(size, i)
    }
}
