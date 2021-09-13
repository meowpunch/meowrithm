package zalando

import scala.annotation.tailrec

object ConsistentFragment {
  /*
   * linear Recursion(tail)
   *
   * @param s:
   */
  def solution(s: String): Int = {
    "sss".length
    @tailrec
    def recFun(charList: List[Char], prevChar: Char, max: Int): Int =
      charList match {
        case Nil => max
        case head :: tail => recFun(tail, head, math.max(max, List(prevChar, head).mkString.toInt))
      }

    s.toList match {
      case h :: t => recFun(t, h, 0)
      case _ => throw new IllegalArgumentException()
    }
  }
}
