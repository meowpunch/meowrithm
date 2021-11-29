package tomtom


/*
    Write a function:

    fun solution(A: IntArray): Int

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
fun solution(A: IntArray): Int {
    val m = Array(A.size + 1) { false }

    for (a in A) {
        if ( 0 < a && a <= A.size) m[a] = true
    }

    for (i in 1..A.size)
        if (!m[i]) return i

    return A.size + 1
}

fun main() {
    println(solution(intArrayOf(1, 3, 6, 4, 1, 2)) == 5)
    println(solution(intArrayOf(1,2,3)) == 4)
    println(solution(intArrayOf(-1, -3)) == 1)
}