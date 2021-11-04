package leetcode

object MergeIntervals {
  def main(args: Array[String]): Unit = {
    print(
      merge(
        Array(
          Array(1, 3),
          Array(7, 8),
          Array(3, 6),
          Array(2, 2)
        )
      )
    )
  }

  /*
      1 2 3 4 5 6 7 8 9
      -----
          ---
        ---------
                  ---

      O(nlogn)


  */
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] =
    intervals.sortBy(_ (0)).foldLeft(List[Array[Int]]()) {
      case (acc, Array(cs, ce)) =>
        acc match {
          case Nil => Array(cs, ce) :: acc
          case Array(s, e) :: t =>
            if (e >= cs) {
              Array(s, ce max e) :: t
            }
            else Array(cs, ce) :: acc
        }
    }.toArray

}
