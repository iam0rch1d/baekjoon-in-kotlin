/**
 * NAndM.kt
 * Class used in problem No.[15649]
 * [range] corresponds to N, [maxDepth] corresponds to M
 */

class NAndM(private val range: Int, private val maxDepth: Int) {
    private var isVisited = BooleanArray(range + 1)
    private var visitedNumber = IntArray(maxDepth)

    private fun dfsPermutation(depth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                print("$element ")
            }

            println("")

            return
        }

        for (i in 1..range) {
            if (!isVisited[i]) {
                isVisited[i] = true
                visitedNumber[depth] = i

                dfsPermutation(depth + 1)

                isVisited[i] = false
            }
        }
    }

    private fun dfsCombination(depth: Int, minDepth: Int) {
        if (depth == maxDepth) {
            for (element in visitedNumber) {
                print("$element ")
            }

            println("")

            return
        }

        for (i in minDepth..range) {
            if (!isVisited[i]) {
                isVisited[i] = true
                visitedNumber[depth] = i

                dfsCombination(depth + 1, i + 1)

                isVisited[i] = false
            }
        }
    }

    fun solveProblem(problemIndex: Int) {
        when (problemIndex) {
            1 -> dfsPermutation(0)
            2 -> dfsCombination(0, 1)
        }
    }
}
