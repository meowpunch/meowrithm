package leetcode

object FindKClosestElements {
  /*
      [1,2,3,4,5], k = 2, x = 3

      l = 0, r = 5
      | 1 - 3 | < | 6 - 3 |

      l = 0, r = 4
   */
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
    // for immutable closure
    val v = arr.toVector

    @annotation.tailrec
    def search(l: Int, r: Int): List[Int] = {
      if (r - l + 1 > k) {
        val (ld, rd) = (math.abs(v(l) - x), math.abs(v(r) - x))
        if (ld > rd) search(l + 1, r)
        else search(l, r - 1)
      } else v.slice(l, r + 1).toList
    }

    search(0, arr.length - 1)
  }
}
