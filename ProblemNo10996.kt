/**
 * ProblemNo10996.kt
 * Star Picture 21
 * https://www.acmicpc.net/problem/10996
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()

    for (i in 1..size) {
        for (j in 1..((size + 1) / 2)) {
            print("* ")
        }

        println()
        print(" ")

        for (j in 1..(size / 2)) {
            print("* ")
        }

        println()
    }
}
