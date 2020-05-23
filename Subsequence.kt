/**
 * Subsequence.kt
 * Class used in problem No.[2565, 11053, 11722, 14002]
 */

class Subsequence(private val sequence: IntArray) {
    private val memoMaxIncreaseLengthIn = IntArray(sequence.size)
    private val memoMaxDecreaseLengthIn = IntArray(sequence.size)
    private val memoMaxBitonicLengthIn = IntArray(sequence.size)
    private val memoIndexLengthIncreasedBy = IntArray(sequence.size)
    private val memoMaxIncreaseElement = IntArray(sequence.size)

    fun getMaxIncreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] < sequence[i] && memoMaxIncreaseLengthIn[i] < memoMaxIncreaseLengthIn[j] + 1) {
                    memoMaxIncreaseLengthIn[i] = memoMaxIncreaseLengthIn[j] + 1
                    memoIndexLengthIncreasedBy[i] = j
                }
            }
        }

        return memoMaxIncreaseLengthIn.max()!!
    }

    fun getMaxDecreaseLength(): Int {
        for (i in (sequence.size - 2) downTo 0) {
            for (j in (sequence.size - 1) downTo (i + 1)) {
                if (sequence[j] < sequence[i] && memoMaxDecreaseLengthIn[i] < memoMaxDecreaseLengthIn[j] + 1) {
                    memoMaxDecreaseLengthIn[i] = memoMaxDecreaseLengthIn[j] + 1
                }
            }
        }

        return memoMaxDecreaseLengthIn.max()!!
    }

    fun getMaxBitonicLength(): Int {
        getMaxIncreaseLength()
        getMaxDecreaseLength()

        for (i in 1 until sequence.size) {
            memoMaxBitonicLengthIn[i] = memoMaxIncreaseLengthIn[i] + memoMaxDecreaseLengthIn[i] - 1
        }

        return memoMaxBitonicLengthIn.max()!!
    }

    fun printMaxIncrease() {
        val maxIncrease = IntArray(getMaxIncreaseLength())

        memoizeMaxIncreaseElement(memoMaxIncreaseLengthIn.indexOf(maxIncrease.size))

        for (i in maxIncrease.indices) {
            print("${memoMaxIncreaseElement[i]} ")
        }

        println()
    }

    private fun memoizeMaxIncreaseElement(index: Int) {
        if (index == 0) {
            return
        } else {
            memoMaxIncreaseElement[memoMaxIncreaseLengthIn[index] - 1] = sequence[index]

            return memoizeMaxIncreaseElement(memoIndexLengthIncreasedBy[index])
        }
    }
}
