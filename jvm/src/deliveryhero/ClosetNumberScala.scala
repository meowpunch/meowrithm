package deliveryhero

object ClosetNumberScala {

  def main(args: Array[String]): Unit = {
    print(
      solution(List(3, 0, 5, 6), 1)
    )
  }

  def solution(xs: List[Int], t: Int) =
    xs.reduce {
      case (l, r) => {
        if (math.abs(r - t) < math.abs(l - t)) r
        else l
      }
    }
}
