/**
 * Subsequence.kt
 * Class used in problem No.[11053, 11722, 14002]
 */

class Subsequence(private val sequence: IntArray) {
    private var memoMaxLengthIn = IntArray(sequence.size)
    private var memoIndexLengthIncreasedBy = IntArray(sequence.size)
    private val memoMaxIncreaseElement = IntArray(sequence.size)

    fun getMaxIncreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] < sequence[i] && memoMaxLengthIn[i] < memoMaxLengthIn[j] + 1) {
                    memoMaxLengthIn[i] = memoMaxLengthIn[j] + 1
                    memoIndexLengthIncreasedBy[i] = j
                }
            }
        }

        return memoMaxLengthIn.max()!!
    }

    fun getMaxDecreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] > sequence[i] && memoMaxLengthIn[i] < memoMaxLengthIn[j] + 1) {
                    memoMaxLengthIn[i] = memoMaxLengthIn[j] + 1
                }
            }
        }

        return memoMaxLengthIn.max()!!
    }

    fun printMaxIncrease() {
        val maxIncrease = IntArray(getMaxIncreaseLength())

        memoizeMaxIncreaseElement(memoMaxLengthIn.indexOf(maxIncrease.size))

        for (i in maxIncrease.indices) {
            print("${memoMaxIncreaseElement[i]} ")
        }

        println("")
    }

    private fun memoizeMaxIncreaseElement(index: Int) {
        if (index == 0) {
            return
        } else {
            memoMaxIncreaseElement[memoMaxLengthIn[index] - 1] = sequence[index]

            return memoizeMaxIncreaseElement(memoIndexLengthIncreasedBy[index])
        }
    }
}
