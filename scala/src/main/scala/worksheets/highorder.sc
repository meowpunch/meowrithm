import scala.collection.immutable.Queue

val xs = List(5, 4, 1, 2, 6, 3)
xs.splitAt(2)
xs.partition(_ > 2)
xs.span(_ != 2)


xs.zipWithIndex.span(_._2 < 3)

val q = Queue(1, 2, 3)
val empty = Queue()
q.dequeue
//empty.dequeue
List("asd", "asdasd").mkString

1.toString

List(1, 2, 3, 4).zip(List(1, 2, 3))
List(1, 2, 3).zip(List(1, 2, 3, 4))
List(1, 2, 3, 4).zipAll(List(1, 2, 3), -1, -1)
List(1, 2, 3).zipAll(List(1, 2, 3, 4), -1, -1)