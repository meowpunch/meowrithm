val odds = generateSequence(1) { it + 2 }.take(100)

arrayOf(1, 2, 3).copyOfRange(1, 1).forEach { println(it) }

IntArray(0).isEmpty()

listOf(1, 2, 3).toIntArray()

(1 to 10).toList()
(1 until 10).toList()
(1..10).toList()

(1..10)
    .filter { it % 2 == 0 }
    .minOrNull()

IntArray(3) { it * 2 }
    .filter { it % 2 == 0 }
    .minOrNull()

var a: Int? = null

a ?: 3

a = 5

a ?: 2



IntArray(3) { -1 }.toList()
//IntArray(3)(-1).toList()

(1..5).flatMap { i ->
    (1..3).map { j -> Pair(i, j) }
}

(1..5).map { i ->
    (1..3).map { j -> Pair(i, j) }
}

IntArray(3) { -1 }.maxOr

(1 until 5)