/**
 * ProblemNo10844.kt
 * Staircase Number (Easy)
 * https://www.acmicpc.net/problem/10844
 */

import java.util.Scanner

const val MODULUS = 1000000000


class StaircaseNumber {
    var memoCount = Array(101) { IntArray(11) }
    private var count: Int = 0

    private fun countAt(digitNo: Int, number: Int): Int {
        if (memoCount[digitNo][number] != 0 || (digitNo == 1 && number == 0)) {
            return memoCount[digitNo][number]
        } else when {
            digitNo == 1 -> {
                memoCount[digitNo][number] = 1
                return 1
            }
            number == 0 -> {
                memoCount[digitNo][number] = countAt(
                    digitNo - 1,
                    number + 1
                ) % MODULUS
            }
            number in 1..8 -> {
                memoCount[digitNo][number] = (countAt(
                    digitNo - 1,
                    number - 1
                ) + countAt(
                    digitNo - 1,
                    number + 1
                )) % MODULUS
            }
            number == 9 -> {
                memoCount[digitNo][number] = countAt(
                    digitNo - 1,
                    number - 1
                ) % MODULUS
            }
        }

        return memoCount[digitNo][number]
    }

    fun getCount(length: Int): Int {
        for (i in 0..9) {
            count = (count + countAt(length, i)) % MODULUS
        }

        return count
    }
}


fun main() = with(Scanner(System.`in`)) {
    val length = nextInt()
    val staircaseNumber = StaircaseNumber()

    println(staircaseNumber.getCount(length))
}
