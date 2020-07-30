package problems.no9521

/**
 * ProblemNo9251.kt
 * LCS
 * https://www.acmicpc.net/problem/9251
 */

class CommonSubsequence(var sequenceFoo: ByteArray, var sequenceBar: ByteArray) {
    fun calculateMaxLength(): Int {
        val maxCommonLength = Array(sequenceFoo.size) { IntArray(sequenceBar.size) }

        for (i in 1 until sequenceFoo.size) {
            for (j in 1 until sequenceBar.size) {
                if (sequenceFoo[i] == sequenceBar[j]) {
                    maxCommonLength[i][j] = maxCommonLength[i - 1][j - 1] + 1
                } else {
                    maxCommonLength[i][j] = maxOf(
                        maxCommonLength[i - 1][j],
                        maxCommonLength[i][j - 1]
                    )
                }
            }
        }

        return maxCommonLength[sequenceFoo.size - 1][sequenceBar.size - 1]
    }
}

fun main() {
    val stringSet = Array(2) { " " + readLine()!! }
    val stringSequence = Array(2) { i: Int -> stringSet[i].toByteArray() }
    val commonSubsequence = CommonSubsequence(stringSequence[0], stringSequence[1])

    for (i in 0..1) {
        stringSequence[i][0] = 0
    }

    println(commonSubsequence.calculateMaxLength())
}
