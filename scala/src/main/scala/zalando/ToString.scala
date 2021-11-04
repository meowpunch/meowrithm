package zalando

object ToString {
  def main(args: Array[String]): Unit = {
    println(
      toBeautifulString(
        List(
          List("one", "two", "three"),
          List("four", "five"),
          List("six", "seven"),
          List("eight", "nine", "ten")
        )
      )
    )
  }


  /*
    input
    [
        ["one", "two", "three"],
        ["four", "five"],
        ["six"]
    ]

    output
    | one  | two  | three |
    | four | five |
    | six  |
 */
  def toBeautifulString(xs: List[List[String]]): String = {
    val maxLengths = maxLengthByColumn(xs)

    xs.map(
      x => x.zip(maxLengths)
        .foldLeft(new StringBuilder("|")) {
          case (sb, (s, l)) => sb.append(String.format(" %-" + l + "s |", s))
        }
        .toString()
    )
      .foldLeft(new StringBuilder) {
        case (sb, s) => sb.append(s).append("\n")
      }
      .toString()
  }

  /*
    input
    [
        ["one", "two", "three"],
        ["four", "five"],
        ["six"]
    ]
          4       4       5
 */
  def maxLengthByColumn(xs: List[List[String]]): List[Int] =
    xs.map(_.map(_.length))
      .reduceLeft(
        (x1, x2) =>
          x1.zipAll(x2, Int.MinValue, Int.MinValue)
            .map { case (a, b) => a max b }
      )

}
