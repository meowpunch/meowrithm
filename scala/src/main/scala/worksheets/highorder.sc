import scala.collection.immutable.Queue

val xs = List(5,4,1,2,6,3)
xs.splitAt(2)
xs.partition(_ > 2)
xs.span(_ != 2)


xs.zipWithIndex.span(_._2 < 3)

val q = Queue(1,2,3)
val empty = Queue()
q.dequeue
empty.dequeue
List("asd","asdasd").mkString

1.toString