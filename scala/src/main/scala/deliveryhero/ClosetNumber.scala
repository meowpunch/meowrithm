package deliveryhero

object ClosetNumber {

  def main(args: Array[String]): Unit = {
    print(
      solution(List(3, 0, 5, 6), 1)
    )
  }

  def solution(xs: List[Int], t: Int): Int =
    xs.reduce((l, r) =>
      if (math.abs(r - t) < math.abs(l - t)) r
      else l
    )
}
