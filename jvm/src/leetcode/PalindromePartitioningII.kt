package leetcode

import kotlin.math.min

class PalindromePartitioningII {

    /**
     * Greedy -> wrong answer
     * 0. loop 0 ... s.length
     * 1. if sub != reversed, there should be partition
     *
     * Dynamic Programming
     * dp(i) represent minimum number of sub palindromes from 0 to i, 0 <= i <= n - 1
     *
     * dp(i) <- min(dp(j) + 1)  if s[j+1, i] is palindrome  0 <= j <= i - 1
     * return dp(n - 1)
     *
     */
    fun minCut2(s: String): Int {
        val n = s.length
        val dp = MutableList(n) {Int.MAX_VALUE}
        dp[0] = 0

        for (i in 1 until n) {
            if (isPalindrome(s.substring(0, i + 1))) {
                dp[i] = 0
                continue
            } else {
                for (j in 0 until i) {
                    if (isPalindrome(s.substring(j + 1, i + 1))) {
                        dp[i] = min(dp[i], dp[j] + 1)
                    }
                }
            }
        }

        return dp[n - 1]
    }

    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) return false
            l++
            r--
        }
        return true
    }

    fun minCut(s: String): Int {
        tailrec fun IntArray.minCut(lo: Int, hi: Int) {
            if (lo >= 0 && hi <= s.lastIndex && s[lo] == s[hi]) {
                set(hi, if(lo == 0) 0 else minOf(get(lo - 1) + 1, get(hi)))
                minCut(lo - 1, hi + 1)
            }
        }
        with(IntArray(s.length) { it }) {
            indices.forEach { lo -> (lo..lo+1).forEach{ hi -> minCut(lo, hi) } }
            return get(lastIndex)
        }
    }
}

fun testIsPalindrome() {
    val instance = PalindromePartitioningII()
    println(instance.isPalindrome(""))
    println(instance.isPalindrome("a"))
    println(instance.isPalindrome("abcba"))

    println(instance.isPalindrome("aab"))
}

fun testMinCut() {
    val instance = PalindromePartitioningII()
    println(instance.minCut("aabaa"))
    println(instance.minCut("aabaac"))
    println(instance.minCut("aabaacbca"))
    println(instance.minCut("aabaaacbca"))
}

fun main() {
    testIsPalindrome()
    testMinCut()
}