package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumJava {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumJava().twoSum(
                new int[]{11, 2, 15, 7},
                9
        )));
    }

    private int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }

        throw new IllegalArgumentException();
    }

    /*
      O(1)/O(n)

      e.g. [15, 7, 11, 2], 9

      i <- 0
      {15: 0}

      i <- 1
      {15: 0, 7: 1}

      i <- 2
      {15: 0, 7: 1, 11: 2}

      i <- 3

      3, 1


   */
    private int[] memoization(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int j = m.getOrDefault(target - nums[i], -1);

            if (j != -1) return new int[]{i, j};
            else m.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }

}
