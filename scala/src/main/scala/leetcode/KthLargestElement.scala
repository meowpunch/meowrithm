package leetcode

object KthLargestElement {
  def findKthLargest(nums: Array[Int], k: Int): Int =
    nums.toSet.toList
      .sorted(Ordering[Int].reverse)
      .take(k).last
}
