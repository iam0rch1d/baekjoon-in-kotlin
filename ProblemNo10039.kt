/**
 * ProblemNo10039.kt
 * Average Score
 * https://www.acmicpc.net/problem/10039
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val examScore = Array(5) { nextInt() }

    for (i in 0..4) {
        examScore[i] = maxOf(examScore[i], 40)
    }

    println(examScore.sum() / 5)
}
