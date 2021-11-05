package zalando

object ToString {
  def main(args: Array[String]): Unit = {
    println(
      toBeautifulString(
        List(
          List("one", "two", "three"),
          List("four", "five"),
          List("six", "seven"),
          List("eight", "nine", "ten", "eleven")
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
      // ["one", "two"] -> | one  | two  |
      x => x.zip(maxLengths).map {
        case (s, l) => String.format("%-" + l + "s", s)
      }.mkString("| ", " | ", " |")
    ).mkString("\n")
  }

  /*
    input
    [
        ["one", "two", "three"],
        ["four", "five"],
        ["six"]
    ]
    output
         4       4       5
 */
  def maxLengthByColumn(xs: List[List[String]]): List[Int] =
    xs.foldLeft(List[Int]())(
      (x1, x2) => x1.zipAll(x2, Int.MinValue, Int.MinValue)
        .map {
          case (v, s: String) => v max s.length
          case (v, s: Int) => v max s
        }
    )

  //      map(_.map(_.length))
  //      .reduceLeft(
  //        (x1, x2) =>
  //          x1.zipAll(x2, Int.MinValue, Int.MinValue)
  //            .map { case (a, b) => a max b }
  //      )

}
