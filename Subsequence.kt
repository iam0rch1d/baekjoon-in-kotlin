/**
 * Subsequence.kt
 * Class used in problem No.[11053, 11722]
 */

class Subsequence(private val sequence: IntArray) {
    private var memoMaxIncreaseLengthAt = IntArray(sequence.size)
    private var memoMaxDecreaseLengthAt = IntArray(sequence.size)

    fun getMaxIncreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] < sequence[i] && memoMaxIncreaseLengthAt[i] < memoMaxIncreaseLengthAt[j] + 1) {
                    memoMaxIncreaseLengthAt[i] = memoMaxIncreaseLengthAt[j] + 1
                }
            }
        }

        return memoMaxIncreaseLengthAt.max()!!
    }

    fun getMaxDecreaseLength(): Int {
        for (i in 1 until sequence.size) {
            for (j in 0 until i) {
                if (sequence[j] > sequence[i] && memoMaxDecreaseLengthAt[i] < memoMaxDecreaseLengthAt[j] + 1) {
                    memoMaxDecreaseLengthAt[i] = memoMaxDecreaseLengthAt[j] + 1
                }
            }
        }

        return memoMaxDecreaseLengthAt.max()!!
    }
}
