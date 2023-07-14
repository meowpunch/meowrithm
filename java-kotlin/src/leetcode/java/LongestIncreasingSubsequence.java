package leetcode.java;

public class LongestIncreasingSubsequence {
    /*
        TODO: enhance performance with binary search
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
}
