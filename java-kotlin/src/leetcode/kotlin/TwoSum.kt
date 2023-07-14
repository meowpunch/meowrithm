package leetcode.kotlin

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val occurrence = HashMap<Int, Int>()

        nums.forEachIndexed { index, value ->
            val diff = target - value
            val diffIndex = occurrence.getOrDefault(diff, -1)

            if(diffIndex == -1) occurrence[value] = index
            else return intArrayOf(diffIndex, index)
        }

        throw IllegalArgumentException()
    }
}