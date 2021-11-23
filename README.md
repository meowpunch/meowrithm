This repository for the following:
 - practice data structures and algorithm
 - with multiple languages: java, scala, kotlin, python, c++, javascript
 - and programming styles: functional, declarative, imperative, object-oriented


## progress
 - WIP: rearrange directories by language

## functional programming
- immutability, tail recursion, highorder function, lazy evaluation

### examples
#### Longest Increasing Subsequence [(leetcode)](https://leetcode.com/problems/longest-increasing-subsequence/)
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

- functional and declarative style with scala
```scala
  /*
     DP solution with highorder function, immutable data structure(List)
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



