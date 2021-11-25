package leetcode

object MaximumSubarray {

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(Array(-2, -1, -3, -4, -1, -2, -1, -5, -4)))
  }

  /*
        - f(i) represents max sum of contiguous subarray ending at index i
        - f(i) <- max (f(i - 1) + arr(i), arr(i))

        return max of f
   */
  def maxSubArray(nums: Array[Int]): Int = {
    @annotation.tailrec
    def loop(xs: List[Int], acc: Int, m: Int): Int =
      xs match {
        case Nil => m
        case h :: t =>
          val lm = h max (acc + h)
          loop(t, lm, m max lm)
      }

    loop(nums.toList, 0, Int.MinValue)
  }

  def maxSubArrayFoldLeft(xs: List[Int]): Int =
    xs.foldLeft((0, Int.MinValue)) {
      case ((localMax, max), e) => {
        val nextLocalMax = localMax max (localMax + e)
        (nextLocalMax, nextLocalMax max max)
      }
    }
      ._2
}
