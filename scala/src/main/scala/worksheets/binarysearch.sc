import scala.annotation.tailrec


def bs(xs: List[Int], t: Int): Boolean = {
  @tailrec
  def helper(xs: List[Int]): Boolean =
    xs.splitAt(xs.length / 2) match {
      case (_, Nil) => false
      case (l, m :: r) =>
        if (m == t) true
        else if (m > t) helper(l)
        else helper(r)
    }

  helper(xs)
}
bs(List(1,2,4,5,7,8), 9)
bs(List(1,2,4,5,7,8), 8)
bs(List(1,2,4,5,7,8), 5)
bs(List(1,2,4,5,7,8), 3)
bs(List(1,2,4,5,7,8), 1)
bs(List(1,2,4,5,7,8), 0)
bs(List(), 1)
