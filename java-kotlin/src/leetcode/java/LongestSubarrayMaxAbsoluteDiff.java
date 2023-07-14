package leetcode.java;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayMaxAbsoluteDiff {

  public static void main(String[] args) {
    System.out.println(new LongestSubarrayMaxAbsoluteDiff().longestSubarray(
        new int[]{8, 2, 4, 7}, 4
    ));
    System.out.println(new LongestSubarrayMaxAbsoluteDiff().longestSubarray(
        new int[]{10,1,2,4,100,2}, 5
    ));
    System.out.println(new LongestSubarrayMaxAbsoluteDiff().longestSubarray(
        new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0
    ));
  }

  /*
      Max Deque stores candidate for maximum value.

      nums = [10,1,2,4,7,2], limit = 5

      (li, ri)
      maxQ
      minQ
      res

      0, 0
      [10]
      [10]
      1

      0, 1
      [10, 1]
      [1]
      1 not updated

      1, 2
      [2]
      [1, 2]
      2

      ...

      1, 4
      [7]
      [1, 2, 4, 7]
      3 not updated

      2, 5
      [7, 2]
      [2]
      4

   */
  public int longestSubarray(int[] nums, int limit) {
    final Deque<Integer> maxDq = new LinkedList<>();
    final Deque<Integer> minDq = new LinkedList<>();

    var maxLength = 0;
    var li = 0;
    for (var ri = 0; ri < nums.length; ri++) {
      while (!maxDq.isEmpty() && maxDq.peekLast() < nums[ri]) maxDq.removeLast();
      maxDq.offerLast(nums[ri]);

      while (!minDq.isEmpty() && minDq.peekLast() > nums[ri]) minDq.removeLast();
      minDq.offerLast(nums[ri]);

      if (maxDq.peekFirst() - minDq.peekFirst() <= limit) {
        if(ri - li + 1 > maxLength) maxLength = ri - li + 1;
      } else {
        if (nums[li] == maxDq.peekFirst()) maxDq.removeFirst();
        if (nums[li] == minDq.peekFirst()) minDq.removeFirst();
        li++;
      }
    }

    return maxLength;
  }

  /*
      Going through nums array with window sliding, keep indices of max and min value


      * How to go through with window sliding *
      nums = [10,1,2,4,7,2], limit = 5

      rightIndex <- 0
      leftIndex <- 0

      (maxLength, maxDiff)
      (1, 0)
      maxq [0]
      minq [0]

      rightIndex <- 1
      leftIndex <- 0

      (1, 9) not updated because 9 is more than limit
      (maxQ, minQ) <- ([0, 1], [1])

      rightIndex <- 1
      leftIndex <- 1

      (1, 0)
      (maxQ, minQ) <- ([1], [1])

      rightIndex <- 2
      leftIndex <- 1

      (2, 1)
      (maxQ, minQ) <- ([2], [1, 2])

      ...

      rightIndex <- 3
      leftIndes <- 1
      (3, 3)
      (maxQ, minQ) <- ([3], [1, 2, 3])

      ri, li <- 4, 1
      ml, d <- 3, 6 not updated
      (maxQ, minQ) <- ([4], [1, 2, 3, 4])

      ri, li <- 4, 2
      ml, d <- 3, 5
      (maxQ, minQ) <- ([4], [2, 3, 4])

      ri, li <- 5, 2
      ml, d <- 4, 5
      (maxQ, minQ) <- ([4, 5], [5])

      output should be 4


      * How to keep max and min *
      - while moving rightIndex, need to update indices of max and min

      There are two deques (maxDeque, minDeque) storing indices of candidates of max and min values sorted by index

      removeFirst indices having values less than num[rightIndex]
      offerLast index of num[rightIndex]

      - while moving leftIndex, need to remove index out of range [l, r]



   */
  public int longestSubarrayWithSlicingWindowIndices(int[] nums, int limit) {
    final Deque<Integer> maxDq = new LinkedList<>();
    final Deque<Integer> minDq = new LinkedList<>();

    var maxLength = 0;
    var li = 0;
    for (var ri = 0; ri < nums.length; ri++) {
      while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[ri]) maxDq.removeLast();
      maxDq.offerLast(ri);

      while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[ri]) minDq.removeLast();
      minDq.offerLast(ri);

      while (li <= ri) {
        System.out.printf("%d %d\n", li, ri);
        System.out.println(maxDq);
        System.out.println(minDq);
        if (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] <= limit) {
          if(ri - li + 1 > maxLength) maxLength = ri - li + 1;
          break;
        } else {
          li++;

          while(!maxDq.isEmpty() && maxDq.peekFirst() < li) maxDq.removeFirst();
          while(!minDq.isEmpty() && minDq.peekFirst() < li) minDq.removeFirst();
        }
      }
    }

    return maxLength;
  }

  /*
    brute force

    O(N^3)

    nums = [10,1,2,4,7,2], limit = 5

    i, j two point

    i = 0 j = 0
    i = 0 j = 1


    f(i, j)
        N <- nums(j)
        if N < minValue of f(i, j - 1),

 */
  public int longestSubarrayNSquare(int[] nums, int limit) {
    var maxLength = 1;

    for (var i = 0; i < nums.length; i++) {
      var j = i;
      var K = new SubSolution(nums[i], nums[i]);
      while (j < nums.length) {
        final int N = nums[j];
        final int length = j - i + 1;

        if (N < K.minValue) {
          if (K.maxValue - N <= limit) {
            K = new SubSolution(K.maxValue, N);
            if (length> maxLength)
              maxLength = length;
          } else {
            K = null;
            break;
          }
        } else if (K.maxValue < N) {
          if (N - K.minValue <= limit) {
            K = new SubSolution(N, K.minValue);
            if (length > maxLength)
              maxLength = length;
          } else {
            K = null;
            break;
          }
        } else {
          K = new SubSolution(K.maxValue, K.minValue);
          if (length > maxLength)
            maxLength = length;
        }

        j++;
      }
    }

    return maxLength;
  }


  record SubSolution(int maxValue, int minValue) {

  }
}
