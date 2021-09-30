package zalando

import scala.annotation.tailrec

object twoNonAdjacentNumbers {
  def main(args: Array[String]): Unit = {
    List(
      Array(5, 4, 7, 3, 2),
      Array(1000000000, 1000000000, 1000000000, 1000000000, 1000000000),
      Array(5, 5, 1, 5, 5, 5, 1, 5, 5),
      Array(5, 5, 5, 5, 5, 5, 5, 5, 5),
      Array(1, 5, 5, 5, 5, 5, 5, 5, 1)
    )
      .map(x => solution(x))
      .foreach(println)
  }

  // minimal sum of two non adjacent elements that divides array into three chain (excluding start and end index)
  // arr.size >= 5
  def solution(arr: Array[Int]): Int = {
    @tailrec
    def recFun(intList: List[Int], prev: Int, prevMin: Int, sumMin: Int): Int =
      intList match {
        // base case
        case head :: _ :: Nil => math.min(head + prevMin, sumMin)
        case head :: tail => recFun(tail, head, math.min(prev, prevMin), math.min(head + prevMin, sumMin))
        case _ => throw new IllegalArgumentException();
      }


    arr.toList match {
      case _ :: m1 :: m2 :: tail => recFun(tail, m2, m1, 2000000000)
      case _ => throw new IllegalArgumentException();
    }
  }
}
