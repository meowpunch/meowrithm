package leetcode.kotlin

class FindTheDuplicateNumber {
    /*
        brute force: O(n^2) / O(1)

        sorting: O(nlogn) / O(n), depending on implementaion of sorting

        memoization: O(n) / O(n)
     */
    fun findDuplicate(nums: IntArray): Int = memoization(nums)

    fun bruteforce(nums: IntArray): Int {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) return nums[i]
            }
        }

        throw IllegalArgumentException()
    }

    fun sorting(nums: IntArray): Int {
        nums.sort()

        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) return nums[i]
        }

        throw IllegalArgumentException()
    }

    fun memoization(nums: IntArray): Int {
        val m = HashSet<Int>()

        for (v in nums) {
            if (m.contains(v)) return v
            else m.add(v)
        }

        throw IllegalArgumentException()
    }
}
