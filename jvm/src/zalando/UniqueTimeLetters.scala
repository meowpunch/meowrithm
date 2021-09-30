package zalando

import scala.annotation.tailrec

object UniqueTimeLetters {

  def main(args: Array[String]): Unit = {
    Seq(
      "ccaaffddecee",
      "",
      "a",
      "abcde"
    )
      .map(solution)
      .foreach(println)

  }

  /*
   * 1. store occurrences of all letters to Map
   *      e.g. ccaaffddecee -> {c => 3, a => 2, f => 2, d => 2, e => 3}
   * 3. sort values of Map
   * 2. delete letters by following maximum occcurence
   *      e.g. 3 3 2 2 2
   *           3 2 2 2 2 (-1)
   *           3 2 1 2 2 (-1)
   *           3 2 1 0 2 (-2)
   *           3 2 1 0 0 (-2)
   *
   *      2 1 1 1 1 1
   */
  def solution(s: String): Int = {
    // 1. build Map
    val l = s.groupBy(identity)
      // 2. sort values of Map
      .values.map(_.length).toList.sorted(Ordering.Int.reverse)

    @tailrec
    def recFun(intList: List[Int], prev: Int, count: Int): Int = {
      intList match {
        case Nil => count
        case head :: tail =>
          // delete count
          // (h, p)
          // 2, 4 => 2, 4
          // 2, 0 => 0, 0
          // 3, 1 => 0, 1
          val c = (prev, head) match {
            case (x, y) if y < x => 0
            case (0, y) => y
            case (x, y) => y - x + 1
          }
          recFun(tail, head - c, count + c)

//          if(head >= prev)
//            if(prev == 0) recFun(tail, 0, count + head)
//            else recFun(tail, prev - 1, count + head - prev + 1)
//          } else recFun(tail, head, count)
      }
    }

    l match {
      case Nil => 0
      case _ => recFun(l.tail, l.head, 0)
    }
  }
}
