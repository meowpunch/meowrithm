package leetcode

object LongestIncreasingSubsequence {

  def main(args: Array[String]): Unit = {
    println(lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)))
  }


  /*
     - f(i) represent the length of LIS ending at index i such that arr[i] is the last element of the LIS.
     - f(i) = 1 + max( f(j) ) where 0 < j < i and arr[j] < arr[i] or L(i) = 1, if no such j exists
   */
  def lengthOfLIS(nums: Array[Int]): Int = {
    // List[(Int, Int)] -> List[(maxLength, maxValue)]
    nums.foldLeft(List[(Int, Int)]()) {
      case (acc, e) => (acc.filter(_._2 < e).map(_._1).maxOption.getOrElse(0) + 1, e) :: acc
    }
      .map(_._1).max
  }
}
