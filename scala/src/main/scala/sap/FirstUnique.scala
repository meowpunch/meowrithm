package sap

import scala.collection.immutable.HashMap

object FirstUnique {
  def main(args: Array[String]): Unit = {
    /*
        input: supercalifragilisticexpialidocious
        output: f
    */
    assert(firstUnique("supercalifragilisticexpialidocious") == 'f')
  }

  def firstUnique(s: String): Char = {
    val cs = s.toList
    val m = getOccurrence(cs)

    @annotation.tailrec
    def helper(cs: List[Char]): Char = {
      cs match {
        case Nil => ' '
        case h :: t => if (m(h) == 1) h else helper(t)
      }
    }

    helper(cs)
  }

  def getOccurrence(cs: List[Char]): Map[Char, Int] = cs.groupBy(identity).map {
    case (k, v) => k -> v.length
  }
}
