package amazon

import scala.annotation.tailrec
import scala.collection.immutable.Queue

object FindMazeScala {
  def main(args: Array[String]): Unit = {
    Seq(
      List(
        "###.######",
        "##.......#",
        "#####.#.##",
        "#.....#..#",
        "#.######.#",
        "########.#"
      ),
      List(
        "###.######",
        "##.......#",
        "#####.#.##",
        "#.....#..#",
        "#.######.#",
        "##########"
      ))
      .map(solution)
      .foreach(print)

  }

  type Row = Int
  type Col = Int
  type Point = (Row, Col)

  /*
      BFS with Queue

      1. find a starting point and push Queue
      2. search by BFS
        2 - 1. pop Queue
        2 - 2. check available direction
        2 - 3. dive into
   */
  def solution(maze: List[String]): Boolean = {

    def findStartingPoint(firstLine: List[Char]): Point = {
      @tailrec
      def loop(i: Int): Point = {
        firstLine(i) match {
          case '.' => (0, i)
          case '#' => loop(i + 1)
          case _ => throw new Exception()
        }
      }

      loop(0)
    }

    def findAvailableNextPoint(p: Point): List[Point] = ???

    def search(q: Queue[Point]): Boolean = {
      if (q.isEmpty) false
      else findAvailableNextPoint(q.head).exists(p => search(q :+ p))
    }

    search(Queue(findStartingPoint(maze.head.toList)))
  }
}


abstract class Direction(val dx: Int, val dy: Int) {

}

object Direction {

}