package leetcode

object LongestSubstringWithoutRepeatingCharacters {
  /*
    - loop in string with index e.g. ('c', 2)
      - if mem has key Char, update prev
      - update mem
      - update acc

    Map: Char -> Int (1 + index of last occurring char)

    a b c a d c
    p     i         mem: a -> 1
      p     i       mem: a -> 2

    a b c c b a
    p     i         mem: c -> 3
          p i       mem: c -> 4
  */
  def lengthOfLongestSubstring(s: String): Int = {
    @annotation.tailrec
    def loop(xs: List[(Char, Int)], mem: Map[Char, Int], prev: Int, acc: Int): Int =
      xs match {
        // base case
        case Nil => acc
        case (v, i) :: t =>
          val p = mem.get(v) match {
            case None => prev
            case Some(x) => prev max x
          }

          loop(t, mem.updated(v, i + 1), p, acc max (i - p + 1))
      }


    loop(s.toList.zipWithIndex, Map.empty, 0, 0)
  }

}
