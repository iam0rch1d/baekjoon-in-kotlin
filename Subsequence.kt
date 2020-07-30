/**
 * Subsequence.kt
 * Class used in problem No.[2565, 11053, 11722, 14002]
 */

class Subsequence(private val sequence: IntArray) {
    private val maxIncreaseLength = IntArray(sequence.size)
    private val maxDecreaseLength = IntArray(sequence.size)
    private val maxBitonicLength = IntArray(sequence.size)
    private val indexIncreasingLength = IntArray(sequence.size)
    private val maxIncreaseElement = IntArray(sequence.size)

    fun calculateMaxIncreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] < sequence[i] && maxIncreaseLength[i] < maxIncreaseLength[j] + 1) {
                    maxIncreaseLength[i] = maxIncreaseLength[j] + 1
                    indexIncreasingLength[i] = j
                }
            }
        }

        return maxIncreaseLength.max()!!
    }

    fun calculateMaxDecreaseLength(): Int {
        for (i in (sequence.size - 2) downTo 0) {
            for (j in (sequence.size - 1) downTo (i + 1)) {
                if (sequence[j] < sequence[i] && maxDecreaseLength[i] < maxDecreaseLength[j] + 1) {
                    maxDecreaseLength[i] = maxDecreaseLength[j] + 1
                }
            }
        }

        return maxDecreaseLength.max()!!
    }

    fun calculateMaxBitonicLength(): Int {
        calculateMaxIncreaseLength()
        calculateMaxDecreaseLength()

        for (i in 1 until sequence.size) {
            maxBitonicLength[i] = maxIncreaseLength[i] + maxDecreaseLength[i] - 1
        }

        return maxBitonicLength.max()!!
    }

    fun printMaxIncrease() {
        val maxIncrease = IntArray(calculateMaxIncreaseLength())

        memoizeMaxIncreaseElement(maxIncreaseLength.indexOf(maxIncrease.size))

        for (i in maxIncrease.indices) {
            print("${maxIncreaseElement[i]} ")
        }

        println()
    }

    private fun memoizeMaxIncreaseElement(index: Int) {
        if (index == 0) {
            return
        } else {
            maxIncreaseElement[maxIncreaseLength[index] - 1] = sequence[index]

            return memoizeMaxIncreaseElement(indexIncreasingLength[index])
        }
    }
}
