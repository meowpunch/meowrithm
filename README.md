This repository for the following:
 - practice data structures and algorithm
 - with multiple languages: java, scala, kotlin, python, c++, javascript
 - and programming styles: functional, declarative, imperative, object-oriented

## functional programming
This part will be moved to scala directory
- features: immutability, tail recursion, highorder function, pattern match, lazy evaluation

### examples
#### Longest Increasing Subsequence [(leetcode)](https://leetcode.com/problems/longest-increasing-subsequence/)

- functional and declarative style with scala
  - highorder function: foldLeft, map, filter etc..
  - immutable data structures: list, which is also [persistent](https://en.wikipedia.org/wiki/Persistent_data_structure).
```scala
  /*
     DP solution
   */
  def lengthOfLIS(nums: List[Int]): Int = {
    // List[(Int, Int)] -> List[(maxLength, maxValue)]
    nums.foldLeft(List[(Int, Int)]()) {
      case (acc, e) => (acc.filter(_._2 < e).map(_._1).maxOption.getOrElse(0) + 1, e) :: acc
    }
      .map(_._1).max
  }
```

Of course, the solution can be improved with binary search. Let's focus on comparing programming styles.

- imperative style with java
```java
    /*
       DP solution
       - f(i) represent the length of LIS ending at index i such that arr[i] is the last element of the LIS.
       - f(i) = 1 + max( f(j) ) where 0 < j < i and arr[j] < arr[i] or L(i) = 1, if no such j exists
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;

        final int N = nums.length;
        final int[] f = new int[nums.length];
        for (int i = 0; i < N; i++) {
            int maxValue = 0;
            for (int j = i -1; j >= 0; j--) {
                if (nums[i] > nums[j]) maxValue = Math.max(maxValue, f[j]);
            }
            f[i] = maxValue + 1;
        }

        // return max of f
        int res = 1;
        for (int i = 1; i < N; i++) res = Math.max(res, f[i]);
        return res;
    }
```

#### Maximum Subarray [(leetcode)](https://leetcode.com/problems/maximum-subarray/)
- tail recursion
```scala
  /*
        - f(i) represents max sum of contiguous subarray ending at index i
        - f(i) <- max (f(i - 1) + arr(i), arr(i))
        return max of f
   */
  def maxSubArray(nums: Array[Int]): Int = {
    @annotation.tailrec
    def loop(xs: List[Int], acc: Int, m: Int): Int =
      xs match {
        case Nil => m
        case h :: t =>
          val lm = h max (acc + h)
          loop(t, lm, m max lm)
      }

    loop(nums.toList, 0, Int.MinValue)
  }
```

