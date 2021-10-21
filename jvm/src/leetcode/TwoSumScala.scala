package leetcode

import scala.annotation.tailrec

object TwoSumScala {
  def main(args: Array[String]): Unit = {
    println(solution(List(5, 2, 1, 4, 7), 6))
    println(solution(List(5, 2, 1, 4, 7), 10)) // throw IllegalArgumentException
  }

  /**
   *
   * 1. Map represents value => index : O(N)
   * e.g. List(3,1,2) => List((3 -> 0), (1 -> 1), (2 -> 2))
   *
   * 2. loop xs again
   * i <- 0 until xs.length
   * j <- Map.get(target - xs(i))
   * if j >= 0 then List(i, j)
   *
   * @param xs e.g. List(5,2,1,4,7), 6
   * @return List(0, 2) or List(2, 0). It means we don't care about ordering.
   */
  def solution(xs: List[Int], t: Int): List[Int] = {
    // tail and linear
    @tailrec
    def loop(xs: List[(Int, Int)], mem: Map[Int, Int]): List[Int] = {
      xs match {
        case Nil => throw new IllegalArgumentException()
        case (v, i) :: tail =>
          mem.get(t - v) match {
            case Some(j) => List(i, j)
            case None => loop(tail, mem + (v -> i))
          }
      }
    }

    loop(xs.zipWithIndex, Map.empty)
  }

  def withIndex(xs: List[Int], t: Int): List[Int] = {
    // tail and linear
    @tailrec
    def loop(i: Int, mem: Map[Int, Int]): List[Int] = {
      if (i >= xs.size) throw new IllegalArgumentException()
      else {
        val v = xs(i)
        mem.get(t - v) match {
          case Some(j) => List(i, j)
          case None => loop(i + 1, mem + (xs(i) -> i))
        }
      }

    }

    loop(0, Map.empty)
  }
}
