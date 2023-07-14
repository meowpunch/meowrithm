package leetcode.kotlin

import kotlin.math.*

class LongestConsecutiveSequence {

    /*
        brute force: O(n^2)


        sorting: O(nlogn)
            - sorting the array in ascending order
            - loop and find ans


        memoization: O(n)
            - map val to idx
            - loop -10^9 .. 10^9 and find ans

     */
    fun longestConsecutive(nums: IntArray): Int {
        return bruteforce(nums)
    }

    private infix fun Int.isConsecutive(x: Int): Boolean = abs(this - x) == 1

    private fun bruteforce(nums: IntArray): Int {
        var maxLength = 0
        for (n in nums) {
            var curr = n
            var tempLength = 1
            while (nums.contains(curr + 1)) {
                tempLength++
                curr++
            }

            maxLength = max(maxLength, tempLength)
        }

        return maxLength
    }

    private fun dp(nums: IntArray): Int {
        val mem = nums.toHashSet()

        var maxLength = 0
        for (v in mem) {
            var curr = v
            var tempLength = 1
            if (mem.contains(v - 1)) continue
            else {
                while (mem.contains(curr + 1)) {
                    tempLength++
                    curr += 1
                }
                maxLength = max(maxLength, tempLength)
            }
        }

        return maxLength
    }

    private fun sorting(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        nums.sort()
        val itr = nums.iterator()

        var prev = itr.nextInt()
        var maxLength = 1
        var tempLength = 1

        while (itr.hasNext()) {
            val curr = itr.nextInt()
            if (curr isConsecutive prev) tempLength++
            else if (curr != prev) {
                maxLength = max(maxLength, tempLength)
                tempLength = 1
            }

            prev = curr
        }

        maxLength = max(maxLength, tempLength)
        return maxLength
    }


}


fun main() {
    println(LongestConsecutiveSequence().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(LongestConsecutiveSequence().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}