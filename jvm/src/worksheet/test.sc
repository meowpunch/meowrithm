case class User(name: String, age: Int)

val userBase = List(
  User("Travis", 28),
  User("Kelly", 33),
  User("Jennifer", 44),
  User("Dennis", 23))

val twentySomethings =
  for (user <- userBase if user.age >=20 && user.age < 30)
    yield user.name  // i.e. add this to a list

userBase
  .filter(user => user.age >=20 && user.age < 30)
  .map(user => user.name)

twentySomethings.foreach(println)


class AClass(_a: Int) {
  val a = _a
}

val a = new AClass(3)
val a = null

def f(a: Int, arr: Array[Int]): Unit = {
  // a = 2 // Invalid to reassignment to val
  arr.update(0, 1)
}

var arr = Array(0,1,2)

f(1, arr)

print(arr.mkString("Array(", ", ", ")"))

print(List(1,2,3)(2))


List().head
List().tail
List(1).tail

List(5,3,1,4).zipWithIndex

List((1 -> 2))
List((1 -> 2 -> 3))

(1, 2)
(1 -> 2)

