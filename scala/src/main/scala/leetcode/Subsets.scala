package leetcode

object Subsets {
  def main(args: Array[String]): Unit = {
    println(subsets(Array(1, 2, 3)))
  }

  /*
    add or not 1 to subsets([2, 3])
  */
  def subsets(nums: Array[Int]): List[List[Int]] = {
    def helper(xs: List[Int]): List[List[Int]] =
      xs match {
        case Nil => List(List())
        case h :: t =>
          for {
            pre <- List(List(), List(h))
            post <- helper(t)
          } yield pre ++ post
      }

    helper(nums.toList)
  }
}
