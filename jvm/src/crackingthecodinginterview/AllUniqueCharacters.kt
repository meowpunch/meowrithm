package crackingthecodinginterview

import com.sun.org.apache.xpath.internal.operations.Bool

class AllUniqueCharacters {

    /*
     * Sorting
     *  time/space: O(NlogN)/O(1)
     * Hashmap
     *  time/space: O(N)/O(N)
     */
    fun solutionWithSorting(target: String): Boolean {
        var prev: Char? = null
        target.toCharArray().sorted().forEach {
            if (prev != it) prev = it
            else return false
        }

        return true
    }

    fun solutionWithHashMap(target: String): Boolean {
        return !target.toList().groupingBy { it }.eachCount()
            .values
            .any { it > 1 }
    }
}

fun testGroupingBy() {
    println(listOf(1, 2, 3, 1, 4).groupingBy { it }.eachCount())
}

fun main() {
    testGroupingBy()

    listOf("meowpunch", "meowpunche")
        .map { AllUniqueCharacters().solutionWithHashMap(it) }
        .forEach { println(it) }
}