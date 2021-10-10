package leetcode

class TopKFrequentElementsKotlin {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.toList()
            .groupingBy { it }.eachCount().toList()
            .sortedByDescending { it.second }
            .take(k).map { it.first }
            .toIntArray()
    }
}