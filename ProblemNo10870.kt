/**
 * ProblemNo10870.kt
 * Fibonacci Number 5
 * https://www.acmicpc.net/problem/10870
 */

import java.util.Scanner

const val FIBONACCI_ZEROTH: Int = 0
const val FIBONACCI_FIRST: Int = 1

fun computeFibonacci(index: Int): Int {
    return when (index) {
        0 -> FIBONACCI_ZEROTH
        1 -> FIBONACCI_FIRST
        else -> computeFibonacci(index - 1) + computeFibonacci(index - 2)
    }
}

fun main() = with(Scanner(System.`in`)) {
    val index = nextInt()

    println(computeFibonacci(index))
}
