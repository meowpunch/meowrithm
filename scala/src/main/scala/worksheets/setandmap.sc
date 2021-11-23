import scala.collection.immutable.{HashMap, TreeMap, TreeSet}

Set(1, 2, 3) // Set
Set(1, 2, 3, 4) // Set
Set(1, 2, 3, 4, 5) // HashSet
TreeSet(5, 4, 3, 2, 1) // TreeSet(1, 2, 3, 4, 5) - SortedSet

Map(1 -> 2, 2 -> 3, 3 -> 4) // Map
Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5) // Map
Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5, 5 -> 6) // HashMap
TreeMap(5 -> 2, 4 -> 3, 3 -> 4, 2 -> 1, 1 -> 6)
// TreeMap(1 -> 6, 2 -> 1, 3 -> 4, 4 -> 3, 5 -> 2) SortedMap

HashMap(1 -> 2, 2 -> 3).head
HashMap(1 -> 2, 2 -> 3).updated(2, 1).head

val jhs = new java.util.HashSet[Int]() // with HashMap
jhs.add(10000)
jhs.add(1)
jhs.add(100)
jhs.add(1000000)
jhs.toArray() // ordered by hashing

val jts = new java.util.TreeSet[Int]() // with TreeMap
jts.add(10000)
jts.add(1)
jts.add(100)
jts.add(1000000)
jts.toArray() // ordered by value (sorted)

new java.util.TreeMap()
