package leetcode;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(
                new SlidingWindowMaximum().arrayMaxInRange(new int[] {5, 4, 3, 2}, 1, 2)
        );

        System.out.println(
                Arrays.toString(new SlidingWindowMaximum().bruteforce(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
        );
    }
    /*
            input  : [1, 2, 3, 4],  k = 3
            output : [3, 4]

            input : [1, 3, -1, -3, 5, 3, 6, 7], k = 3

            i - index
            q - queue will store the index of the promising element of array
            r - result

                i = 0
                q = [0]

                i = 1
                q = [1]

                i = 2
                q = [1, 2]
                r = [3]

                i = 3
                q = [1, 2, 3]
                r = [3, 3]

                i = 4
                q = [4]
                r = [3, 3, 5]

                i = 5
                q = [4, 5]
                r = [3, 3, 5, 5]

                i = 6
                q = [6]
                r = [3, 3, 5, 5, 6]

                i = 7
                q = [7]
                r = [3, 3, 5, 5, 6, 7]



        brute force
        -


        - loop nums with two pointers i, j (j - 1 + 1 = k)

     */

    // max arr[k], i <= k <= j
    public int arrayMaxInRange(int[] arr, int i, int j) {
        int m = arr[i++];
        while (i <= j) {
            m = Math.max(m, arr[i++]);
        }
        return m;
    }

    public int[] bruteforce(int[] nums, int k) {
        final int windowNum = nums.length - k + 1;
        final int[] res = new int[windowNum];

        int i = 0;
        int j = k - 1;

        while (j < nums.length) res[i] = arrayMaxInRange(nums, i++, j++);

        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        /*
            looks like O(n^2) because of nested loop
            Two while loop could operate n times because n elements of nums can be stored at deque just one time.

            So, time complexity is O(n), linear
         */
        for (int i = 0; i < nums.length; i++) {
            // dequeue front elements  out of range of window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();

            // dequeue back elements smaller than num[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            // enqueue index i, promising element
            dq.offer(i);

            // add max to result
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}
