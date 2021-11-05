def m(x: Int): Int = {
  println(s"map $x")
  x + 1
}

def f(x: Int): Boolean = {
  println(s"filter $x")
  x % 2 == 0
}

val xs = (0 to 10).toList

xs
  .filter(f)
  .map(m)

val vs = xs.view
vs
  .filter(f)
  .map(m)
  .take(3)
  .toList

vs

val ls = LazyList.from(xs)
ls
  .filter(f)
  .map(m)
  .toList

ls
