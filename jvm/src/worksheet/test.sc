case class User(name: String, age: Int)

val userBase = List(
  User("Travis", 28),
  User("Kelly", 33),
  User("Jennifer", 44),
  User("Dennis", 23))

val twentySomethings =
  for (user <- userBase if user.age >= 20 && user.age < 30)
    yield user.name // i.e. add this to a list

userBase
  .filter(user => user.age >= 20 && user.age < 30)
  .map(user => user.name)

twentySomethings.foreach(println)


class AClass(_a: Int) {
  val a = _a
}

val a = new AClass(3)
val a = null

def f(a: Int, arr: Array[Int]): Unit = {
  print(arr.mkString("Array(", ", ", ")"))
  arr.update(0, 1)
}

val arr = Array(0, 1, 2)
arr.update(1, 3)
f(1, arr)

print(arr.mkString("Array(", ", ", ")"))

print(List(1, 2, 3)(2))


List().head
List().tail
List(1).tail

List(5, 3, 1, 4).zipWithIndex

List((1 -> 2))
List((1 -> 2 -> 3))

(1, 2)
1 -> 2

val A1 = Array(Array(4, 0, 0, 0), Array(3), Array(3, 4, 40, 1), Array(50, 2))

A1.transpose
List(List(4, 0, 0, 0), List(3), List(3, 4, 40, 1), List(50, 2)).transpose


A1.reduceLeft((x1, x2) =>
  x1.zipAll(x2, Int.MinValue, Int.MinValue)
    .map { case (x, y) => x max y }
)

Array(4, 0, 0, 0).zipAll(Array(3, 2, 1), 100, 100)

List(1).zipAll(List(1, 2, 3, 4), 100, -100)

List(1).zip(List(1, 2))

List(1, 2) zip List(1)

List(1, 2).zipAll(List('a'), 3, 'c')

List(1).zipAll(List('a', 'b'), 3, 'c')

val s = "abc"
val n = 10
f"${s}%-" + n + "s"
String.format("%-" + n + "s", n)

println(List(1, 3, 2).sorted == List(3, 2, 1).sorted)

Set(1, 2) + 3


Set(List(1, 3, 2), List(3, 2, 1)).map(xs => xs.sorted)

Map.empty.withDefaultValue(false)(1)

Array(Array(1, 2, 3)).head
Vector.fill(5)(Vector(0))


def a(i: Int, j: Int) = print(i + j)

for {
  i <- 0 to 10
  j <- 0 to 5
  if (i + j) % 2 == 0
} yield {
  a(i, j)
  1
}



(1 -> 2)(1)


