package leetcode.kotlin

class CoinChange {
    /*
       f(i) represents the fewest number of coins that made up `i` amount.
       coins is array of coins.

       f(i) = min of f(i - c) for c in coins
   */
    fun coinChange(coins: IntArray, amount: Int): Int {
        val f = IntArray(amount + 1) { -1 }
        f[0] = 0

        for (i in 1..amount) {
            val m = coins
                .map { i - it }
                .filter { it >= 0 }
                .map { f[it] }
                .filter { it != -1 }
                .min()

            f[i] = if (m != null) m + 1 else -1
        }

        return f[amount]
    }

}

fun main() {
    println(
        CoinChange().coinChange(
            listOf(1, 5).toIntArray(), 11
        )
    )
}