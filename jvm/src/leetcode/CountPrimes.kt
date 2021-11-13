package leetcode

import kotlin.math.sqrt

class CountPrimes {
    /*
        Sieve of Eratosthenes

        - erase non primes
            - for i <- 2 to n*n

        - count the number of primes

     */
    fun countPrimes(n: Int): Int {
        // primitive
        val isPrime = BooleanArray(n) { i -> !(i == 0 || i == 1) }

        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (!isPrime[i]) continue
            else {
                for (j in 2 * i until n step i) isPrime[j] = false
            }
        }

        return isPrime.count { it }
    }

}

fun main() {
    // 2 3 5 7
    println(CountPrimes().countPrimes(10))
//    assert(CountPrimes().countPrimes(10) == 4)
}