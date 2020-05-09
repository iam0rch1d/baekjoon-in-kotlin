/**
 * ProblemNo14681.kt
 * Quadrant Selection
 * https://www.acmicpc.net/problem/14681
 */

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val xPosition = nextInt()
    val yPosition = nextInt()

    println(
        if (xPosition > 0 && yPosition > 0) "1"
        else if (xPosition < 0 && yPosition > 0) "2"
        else if (xPosition > 0 && yPosition < 0) "4"
        else "3"
    )
}
