package leetcode

import scala.annotation.tailrec

object ThreeSum {
  /*
      O(


   */
  def main(args: Array[String]): Unit = {
    println(bruteforce(Array(-1, 0, 1, 2, -1, -4).toList.sorted, Set()))

    println(dp(Array(-1, 0, 1, 2, -1, -4).toList, Set()))
    print(twoSum(List(1, -1, 1, -1), 0))
  }


  /*
      * Input should be sorted for removing duplicates
      Input: nums = [-1,0,1,2,-1,-4].sorted
      Output: [[-1,-1,2],[-1,0,1]]
   */
  @tailrec
  def bruteforce(xs: List[Int], acc: Set[List[Int]]): Set[List[Int]] = {
    xs match {
      case Nil => acc.filter(ys => ys.size == 3 && ys.sum == 0)
      case h :: t => bruteforce(t, acc ++ acc.filter(_.size < 3).map(ys => h :: ys) + List(h))
    }
  }

  /*
      O(n^2)
      x + y + z = 0
      => x + y = -z

      O(n)
      twoSum(arr , target)

   */
  def dp(xs: List[Int], acc: Set[List[Int]]): List[List[Int]] = {
    xs match {
      case xs if xs.size < 3 => acc.toList
      case h :: t => dp(t, acc ++ twoSum(t, -h))
    }
  }

  /*
      m: memoize occurrence of element

      input: [-1, 1, -1, -1], 0
      output: [-1, 0, 1]
   */
  def twoSum(xs: List[Int], tar: Int): Set[List[Int]] = {
    @annotation.tailrec
    def helper(xs: List[Int], m: Map[Int, Boolean], acc: Set[List[Int]]): Set[List[Int]] = {
      xs match {
        case Nil => acc
        case h :: t =>
          helper(
            t,
            m.updated(h, true),
            if (m(tar - h)) acc + List(tar - h, h, -tar).sorted
            else acc
          )
      }

    }

    helper(xs, Map.empty.withDefaultValue(false), Set())
  }
}
