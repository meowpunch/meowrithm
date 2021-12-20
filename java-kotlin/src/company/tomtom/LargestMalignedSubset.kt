package company.tomtom


/*
    (-3, -2, 1, 0, 8, 7, 1, 6), 3

    Task score: 62%

    1. mod
        (0, 1, 1, 0, 2, 1, 1, 0)
    2. count occurrence
        0: 3, 1: 4, 2: 1
    3. max
        4
 */
fun solution(A: IntArray, M: Int): Int {
    return A.map { a -> mod(a, M) }
        .groupingBy { it }.eachCount()
//        .maxOfOrNull { it.value } ?: 0
        .values.max() ?: 0
}

fun mod(a: Int, M: Int): Int = if (a >= 0) a % M else (a % M + M) % M

fun main() {
    println(mod(-6, 3)) // 1
    println(mod(-5, 3)) // 1
    println(mod(-4, 3)) // 2
    println(mod(-3, 3)) // 0
    println(mod(-2, 3)) // 1
    println(mod(-1, 3)) // 2
    println(mod(0, 3))  // 0

    println("\nTest solution")
    println(solution(intArrayOf(-3, -2, 1, 0, 8, 7, 1, 6), 3))
    println(solution(intArrayOf(7, 1, 11, 8, 4, 10), 8))
    println(solution(intArrayOf(), 1))
    println(solution(intArrayOf(10, 5), 4)) // 1
    println(solution(intArrayOf(8, -8), 4)) // 2
    println(solution(intArrayOf(10000, -10000), 1)) // 2
}