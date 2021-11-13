val a: Int = 10000
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 100
val boxedB: Int? = b
val anotherBoxedB: Int? = b

// structural equality
boxedA == anotherBoxedA
// referential equality
boxedA === anotherBoxedA

boxedB == anotherBoxedB
// memory optimization on JVM
boxedB === anotherBoxedB
