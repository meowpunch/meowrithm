
val a = generateSequence(0) { i -> println(i + 1); i + 1 }

a.take(5).toList()
// recalculate from 5
a.take(10).toList()

sequenceOf(1, 2, 3) + 4

listOf(1, 2, 3) + 4
