package leetcode

object TopKFrequentElements {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] =
    // map element to number of occurrence of the element
    nums.groupBy(identity).map(t => (t._1, t._2.length)).toList
      // sort by # of occurrence in descending order and take k elements
      .sortBy(- _._2).take(k)
      .map(_._1).toArray
}
