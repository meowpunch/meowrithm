val xs: LazyList[Int] = LazyList.from(0)
  .filter(x => {
    println(s"$x is computed")
    x % 2 == 0
  })

xs.take(1).toList
xs.take(3).toList
xs.take(5).toList

def ys: LazyList[Int] = LazyList.from(0)
  .filter(x => {
    println(s"$x is computed")
    x % 2 == 0
  })

ys.take(1).toList
ys.take(2).toList

val evens: LazyList[Int] = 2 #:: LazyList.from(3)
  .filter(x => {
    println(s"$x is computed")
    x % 2 == 0
  })

evens.take(1).toList
evens.take(2).toList
evens.take(3).toList

evens.takeWhile(_ <= 10).toList


val primes: LazyList[Int] = 2 #:: LazyList.from(3).filter(
  x => {
    println(s"$x is computed")
    primes.takeWhile(_ <= math.sqrt(x)).forall(x % _ != 0)
  }
)

primes.takeWhile(_ < 6).size

primes.takeWhile(_ < 6).foldLeft(0)((a, _) => a + 1)


