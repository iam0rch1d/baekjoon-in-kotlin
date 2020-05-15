/**
 * NAndM.kt
 * Class used in problem No.[15649]
 * [range] corresponds to N, [maxDepth] corresponds to M
 */

class NAndM(private val range: Int, private val maxDepth: Int) {
    private var isVisited = BooleanArray(range + 1)
    private var visitedNumber = IntArray(maxDepth)

    private fun goDepthFirstSearch(depth: Int) {
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

                goDepthFirstSearch(depth + 1)

                isVisited[i] = false
            }
        }
    }

    fun takeOne() {
        goDepthFirstSearch(0)
    }
}
