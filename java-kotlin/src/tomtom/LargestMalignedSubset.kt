package tomtom


/*
    (-3, -2, 1, 0, 8, 7, 1, 6), 3

    Task score: 62%

    1. mod
    2. count occurrence
    3. max
 */
fun solution(A: IntArray, M: Int): Int {
    return A.map { a -> if (a >= 0) a % M else (a % M) + M }
        .groupingBy { it }.eachCount()
//        .maxOfOrNull { it.value } ?: 0
        .values.max() ?: 0
}

fun main() {
    println(solution(intArrayOf(-3, -2, 1, 0, 8, 7, 1, 6), 3))
    println(solution(intArrayOf(7, 1, 11, 8, 4, 10), 8))
    println(solution(intArrayOf(), 1))
    println(solution(intArrayOf(2, 5), 4))
    println(solution(intArrayOf(10, 5), 4))
}