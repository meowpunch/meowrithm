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

