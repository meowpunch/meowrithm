package zalando

import zalando.CalculateStatistics.{ENTER, EXIT, SPLITTER}

class CalculateStatistics {
  /*
    preprocessing
    String => List[String] => List[Log]

    analyze
    List[Log] => List[Statistics]
   */
  type Log = (Int, String, Option[String])

  def preprocess(xs: List[String]): List[Log] =
    xs.map(
      _.split(SPLITTER) match {
        case Array(t, b, m) => (t.toInt, b, Option(m))
        case Array(t, b) => (t.toInt, b, Option.empty)
      }
    )

  /*
      Enter -> push
      Exit -> pop and add Statistics

      Map: method name -> statistics
   */
  def analyze(xs: List[Log]): Map[String, Statistics] = {
    @annotation.tailrec
    def loop(xs: List[Log], stk: List[Log], acc: Map[String, Statistics]): Map[String, Statistics] = {
      xs match {
        case Nil => acc
        case h :: t => h match {
          // push
          case (_, ENTER, _) => loop(t, h :: stk, acc)
          case (ext, EXIT, None) =>
            stk match {
              // pop and accumulate statistics
              case (ent, ENTER, Some(m)) :: st =>
                acc.get(m) match {
                  case Some(s) => loop(t, st, acc.updated(m, Statistics(m, s.totalTime + ext - ent, s.totalNumber + 1)))
                  case None => loop(t, st, acc.updated(m, Statistics(m, ext - ent, 1)))
                }
              case _ => throw new IllegalArgumentException()
            }
        }
        case _ => throw new IllegalArgumentException()
      }
    }

    loop(xs, List(), Map.empty)
  }


}

case class Statistics(methodName: String, totalTime: Double = 0, totalNumber: Double = 0) {
  def average: Double = totalTime / totalNumber
}

object CalculateStatistics {
  // better to be enum
  val ENTER = "Enter"
  val EXIT = "Exit"

  val SPLITTER = ";"

  /*
    input
    "0;Enter;Method_A",
    "10;Enter;Method_B",
    "15;Exit",
    "17;Exit",
    "18;Enter;Method_C",
    "22;Exit",
    "23;Enter;Method_B",
    "25;Enter;Method_A",
    "31;Exit",
    "33;Exit"
   */
  def main(args: Array[String]): Unit = {
    val cs = new CalculateStatistics()
    val p = cs.preprocess(
      List(
        "0;Enter;Method_A",
        "10;Enter;Method_B",
        "15;Exit",
        "17;Exit",
        "18;Enter;Method_C",
        "22;Exit",
        "23;Enter;Method_B",
        "25;Enter;Method_A",
        "31;Exit",
        "33;Exit"
      )
    )

    val m = cs.analyze(p)
    println(m)
    m.foreach(s => println(s"${s._1} avg: ${s._2.average}"))
  }
}
