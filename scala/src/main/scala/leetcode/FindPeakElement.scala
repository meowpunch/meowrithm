package leetcode

object FindPeakElement {
  def findPeakElement(nums: Array[Int]): Int = {
    // linear(nums)
    binarysearch(nums)
  }

  def linear(nums: Array[Int]): Int = {
    @annotation.tailrec
    def helper(xs: List[(Int, Int)], prev: (Int, Int)): Int = {
      xs match {
        case h :: t => if (prev._1 > h._1) prev._2 else helper(t, h)
        case Nil => prev._2
      }
    }

    helper(nums.toList.zipWithIndex, Int.MinValue -> -1)
  }


  def binarysearch(nums: Array[Int]): Int = {
    @annotation.tailrec
    // s: starting point, e: ending point
    def helper(s: Int, e: Int): Int = {
      // base case
      if (s >= e) s
      else {
        val m = (s + e) / 2

        if (nums(m + 1) > nums(m)) helper(m + 1, e)
        else helper(s, m)
      }
    }

    helper(0, nums.size - 1)
  }
}
