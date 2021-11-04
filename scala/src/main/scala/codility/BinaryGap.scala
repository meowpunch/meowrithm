package codility

import scala.annotation.tailrec

object BinaryGap {
  def main(args: Array[String]): Unit = {
    solution(9)
    solution(1041)
  }

  /**
   * 1. Int to BinaryString e.g. ? -> "100100010"
   * 2. trimZero            e.g. "100100010" -> "10010001"
   * 3. split by 1          e.g. ["", "00", "000"]
   * 4. max by length       e.g. 3
   */
  def solution(n: Int): Int =
    trimZero(n.toBinaryString).split("1").toList match {
      case Nil => 0
      case arrList => arrList.map(s => s.length).max
    }

  @tailrec
  def trimZero(s: String): String =
    if (s(0) != '0' && s.last != '0') s
    else trimZero(
      s.slice(if (s(0) == '0') 1 else 0, if (s.last == '0') s.length - 1 else s.length)
    )
}
