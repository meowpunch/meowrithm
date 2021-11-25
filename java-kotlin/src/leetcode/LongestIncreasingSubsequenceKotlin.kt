package leetcode

class LongestIncreasingSubsequenceKotlin {
    /*
        f(i) represents the longest length of increasing subsequence including i-th element

        f(i) <- max of f(k) if A(i) > A(k) in 0 < k < i
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val f = IntArray(nums.size) { 1 }

        for (i in 1 until nums.size) {
            val m = (0 until i)
                .filter { nums[it] < nums[i] }
                .map { f[it] }
                .max() ?: 0


            f[i] = m + 1
        }

        return f.max() ?: -1
    }
}