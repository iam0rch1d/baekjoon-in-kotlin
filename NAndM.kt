/**
 * NAndM.kt
 * Class used in problem No.[15649..15652]
 * Range corresponds to N, maxDepth corresponds to M
 */

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.System.out

class NAndM(private val range: Int, private val maxDepth: Int) {
    private var isVisited = BooleanArray(range + 1)
    private var visitedNumber = IntArray(maxDepth)
    private val bufferedWriter = BufferedWriter(OutputStreamWriter(out))

    fun printPermutation(depth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                bufferedWriter.write("$element ")
            }

            bufferedWriter.newLine()
            bufferedWriter.flush()

            return
        }

        for (i in 1..range) {
            if (!isVisited[i]) {
                isVisited[i] = true
                visitedNumber[depth] = i

                printPermutation(depth + 1)

                isVisited[i] = false
            }
        }
    }

    fun printCombination(depth: Int, minDepth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                bufferedWriter.write("$element ")
            }

            bufferedWriter.newLine()
            bufferedWriter.flush()

            return
        }

        for (i in minDepth..range) {
            if (!isVisited[i]) {
                isVisited[i] = true
                visitedNumber[depth] = i

                printCombination(depth + 1, i + 1)

                isVisited[i] = false
            }
        }
    }

    fun printRepetitivePermutation(depth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                bufferedWriter.write("$element ")
            }

            bufferedWriter.newLine()
            bufferedWriter.flush()

            return
        }

        for (i in 1..range) {
            visitedNumber[depth] = i

            printRepetitivePermutation(depth + 1)
        }
    }

    fun printRepetitiveCombination(depth: Int, minDepth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                bufferedWriter.write("$element ")
            }

            bufferedWriter.newLine()
            bufferedWriter.flush()

            return
        }

        for (i in minDepth..range) {
            visitedNumber[depth] = i

            printRepetitiveCombination(depth + 1, i)
        }
    }
}
