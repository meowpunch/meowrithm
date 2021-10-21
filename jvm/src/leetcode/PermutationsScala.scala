package leetcode

object PermutationsScala {
  /*
    1 <= nums.length <= 6

    permutations of [1,2,3]
    1 + perm of [2, 3], 2 + perm of [1, 3], 3 + perm of [1, 2]
  */
  def permute(nums: Array[Int]): List[List[Int]] = {
    def permute(xs: List[Int]): List[List[Int]] =
      if (xs.isEmpty) List(List())
      else
        for {
          i <- xs
          p <- permute(xs.filter(x => x != i))
        } yield p :+ i

    permute(nums.toList)
  }
}
