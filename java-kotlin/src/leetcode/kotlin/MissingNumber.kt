package leetcode.kotlin

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        // missing one value of 0 ~ n
        return n * (n + 1) / 2 - nums.sum()
    }
}