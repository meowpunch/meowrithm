package leetcode.kotlin

import kotlin.math.min

class LongestCommonPrefix {
    /**
     *
     *
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        return strs.fold(strs[0]) {
            prefix: String, current: String -> findPrefix(prefix, current)
        }
    }

    fun findPrefix(l: String, r: String): String {
        val stdLength = min(l.length, r.length)

        for ( idx in 0 until stdLength) {
            if (l[idx] != r[idx]) return l.substring(0, idx)
        }

        return l.substring(0, stdLength)
    }
}

fun main() {
    println(LongestCommonPrefix().longestCommonPrefix(listOf("flower","flow","flight").toTypedArray()))
    println(LongestCommonPrefix().findPrefix("abcd", "abd"))
    println(LongestCommonPrefix().findPrefix("ab", "abcd"))
}

