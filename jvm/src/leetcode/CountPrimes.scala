package leetcode

import scala.annotation.tailrec
import scala.collection.immutable.HashMap

object CountPrimes {

  val primes: LazyList[Int] = 2 #:: LazyList.from(3).filter(
    x => primes.takeWhile(_ <= math.sqrt(x)).forall(x % _ != 0)
  )


  def countPrimes(n: Int): Int =
  // countPrimesNestedLoop(n)
    countPrimesAdvanced(n)


  def countPrimesAdvanced(n: Int): Int =
    primes.takeWhile(_ < n) // `.size` needs more memory (I want to know why)
      .foldLeft(0)((acc, _) => acc + 1)


  /*
      Sieve of Eratosthenes

      i (2 to sqrt(n))

      if i isNotPrime then continue
      else
          j (i*i until n by i)
          isPrime(n) = true;
   */
  def countPrimesImmutableSieve(n: Int): Int = {
    if (n < 2) 0

    /*
        Map[Int, Boolean]
        (number -> isPrime)

        loop i (2 to sqrt(n))
    */
    @tailrec
    def helper(i: Int, isPrime: Map[Int, Boolean]): Map[Int, Boolean] =
    // terminal
      if (i > math.sqrt(n)) return isPrime
      // i is not prime
      else if (!isPrime(i)) helper(i + 1, isPrime)
      // i is prime
      else helper(i + 1, (i * i until n by i).foldLeft(isPrime)((acc, ele) => acc.updated(ele, false)))

    val isPrime = helper(2, Map.empty.withDefaultValue(true))
    (2 until n).count(isPrime)
  }


  /*
      check if k (2 until n) is prime O(n^2)
   */
  def countPrimesNestedLoop(n: Int): Int =
    (2 until n)
      .count(isPrime)


  // Prime is represented in the case that there was no divisor other than 1 and itself(n > 1)
  // check if there is k that can divide n (1 < k < n) => O(n)
  def isPrime(n: Int): Boolean =
    if (n < 2) false
    else !(2 to math.sqrt(n).toInt).exists(k => n % k == 0)


}
