package zalando

import scala.annotation.tailrec

object twoAdjacentNumbers {
  def main(args: Array[String]): Unit = {
    List(Array(5,4,7,3,2), Array(1000000000,1000000000,1000000000,1000000000,1000000000))
      .map(x => solution(x))
      .foreach(x => println(x))
  }

  // minimal sum of two adjacent elements that divides array into three chain
  def solution(arr: Array[Int]): Int = {
    @tailrec
    def recFun(intList: List[Int], prev: Int, prevMin: Int, sumMin: Int): Int =
      intList match {
        case head :: _ :: Nil => math.min(head + prevMin, sumMin)
        case head :: tail => recFun(tail, head, math.min(prev, prevMin), math.min(head + prevMin, sumMin))
      }


    arr.toList match {
      case _ :: m1 :: m2 :: tail => recFun(tail, m2, m1, 2000000000)
      case _ => throw new IllegalArgumentException();
    }
  }
}
