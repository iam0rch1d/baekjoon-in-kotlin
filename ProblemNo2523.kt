/**
 * ProblemNo2523.kt
 * Star Picture 13
 * https://www.acmicpc.net/problem/2523
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()

    for (i in 1..size) {
        for (j in 1..i) {
            print("*")
        }

        println()
    }

    for (i in (size - 1) downTo 1) {
        for (j in 1..i) {
            print("*")
        }

        println()
    }
}
