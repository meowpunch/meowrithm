

// Array
Array(1, 2, 3, 4) match {
  case Array() => println("empty")
  case Array(h, _*) => println(h)
}