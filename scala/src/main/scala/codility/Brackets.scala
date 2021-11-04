package codility

import scala.annotation.tailrec

object Brackets {

  def solution(s: String): Int = {
    @tailrec
    def recFun(charList: List[Char], stack: List[Char]): Int =
      charList match {
        case Nil => if (stack.isEmpty) 1 else 0
        case head :: tail =>
          stack match {
            case Nil => recFun(tail, head :: stack)
            case top :: bottom =>
              head match {
                case '(' | '{' | '[' => recFun(tail, head :: top :: bottom)
                case closedBracket => if (matchBracket(closedBracket) == top) recFun(tail, bottom) else 0
              }
          }
      }

    recFun(s.toList, List())
  }

  def matchBracket(b: Char): Char =
    b match {
      case '(' => ')'
      case ')' => '('
      case '{' => '}'
      case '}' => '{'
      case '[' => ']'
      case ']' => '['
      case _ => throw new IllegalArgumentException()
    }
}
