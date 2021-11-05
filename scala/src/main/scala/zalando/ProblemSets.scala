package zalando

object ProblemSets {
  val SPLITTER = " "

  def main(args: Array[String]): Unit = {
    println(processQ2("My Name Is Peter The Cat"))

    println(processQ7(
      List((1, "a"), (2, "b"), (3, "c"), (4, "b")).toMap,
      List(("a", true), ("b", false)).toMap
    ))

    List(2, 2, 3).foreach(
      i => println(cachedAddTwo(i))
    )
  }

  /*
    Time/Space: O(N)/

    - split String splitter, " " List[Char]  e.g. [My, Name ...]
    - zipWithIndex List[(String, Int)]  e.g. [(My, 0), (Name, 1) ...]
    - reverse if index is even
  */
  def processQ2(s: String): String =
    s
      .split(SPLITTER) // O(N)
      .view // lazy evaluation
      .zipWithIndex // O(N)
      .map { case (v, i) =>
        if (i % 2 == 0) {
          val x = v.toLowerCase.reverse
          x.updated(0, x.head.toUpper)
        }
        else v
      } // O(N)
      .mkString(SPLITTER) // O(N)


  /*
      Time: O(N)

      a = map(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "b")
      b = map("a" -> true, "b" -> false)

      combine(a, b) => map(1 -> true, 2 -> false, 4 -> false)
   */
  def processQ7(a: Map[Int, String], b: Map[String, Boolean]): Map[Int, Boolean] = {
    a // List[(Int, String)] //O(N)
      .view
      .filter { case (_, s) => b.contains(s) } //O(N) -> m
      .map { case (i, s) => (i, b(s)) } //O(m)
      .toMap
  }

  def addTwo(x: Int): Int = add(x)(2)

  val cache = new scala.collection.mutable.HashMap[Int, Int]()

  def cachedAddTwo(x: Int): Int = {
    cache.get(x) match {
      case Some(v) => v
      case None => {
        val o = addTwo(x)
        // mutate
        cache.update(x, o)
        o
      }
    }
  }

  def add(x: Int)(y: Int): Int = x + y


}
