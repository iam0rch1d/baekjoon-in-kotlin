package problems.no10844

/**
 * ProblemNo10844.kt
 * Staircase Number (Easy)
 * https://www.acmicpc.net/problem/10844
 */

import java.util.*

const val MODULUS = 1000000000

class StaircaseCounter {
    private var numStaircaseStartingWith = Array(101) { IntArray(10) }
    private var numStaircase = 0

    private fun calculateNumStaircaseAt(digitNo: Int, number: Int): Int {
        // Check if to go dynamic
        if (numStaircaseStartingWith[digitNo][number] == 0 && (digitNo != 1 || number != 0)) {
            when {
                digitNo == 1 -> {
                    numStaircaseStartingWith[digitNo][number] = 1

                    return 1
                }
                number == 0 -> {
                    numStaircaseStartingWith[digitNo][number] = calculateNumStaircaseAt(
                        digitNo - 1,
                        number + 1
                    ) % MODULUS
                }
                number in 1..8 -> {
                    numStaircaseStartingWith[digitNo][number] = (calculateNumStaircaseAt(
                        digitNo - 1,
                        number - 1
                    ) + calculateNumStaircaseAt(
                        digitNo - 1,
                        number + 1
                    )) % MODULUS
                }
                number == 9 -> {
                    numStaircaseStartingWith[digitNo][number] = calculateNumStaircaseAt(
                        digitNo - 1,
                        number - 1
                    ) % MODULUS
                }
            }
        }

        return numStaircaseStartingWith[digitNo][number]
    }

    fun solve(length: Int): Int {
        for (i in 0..9) {
            numStaircase = (numStaircase + calculateNumStaircaseAt(length, i)) % MODULUS
        }

        return numStaircase
    }
}

fun main() = with(Scanner(System.`in`)) {
    val length = nextInt()
    val staircase = StaircaseCounter()

    println(staircase.solve(length))
}
