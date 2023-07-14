package leetcode.java;

public class FirstMissingPositive {
    /*
        time/space: O(N)/O(1)
        - put valid positive integer (p) at index p - 1

        0 1 2 -> 1 2 0

        3   4   -1  1 -> 1   -1   3  4

        7 8 9 10 11 12 -> 7 8 9 10 11 12
     */
    public int firstMissingPositive(int[] nums) {
        final int N = nums.length;

        int i = 0;
        while (i < N) {
            final int v = nums[i];

            /*
                check valid positive integer & already valid position & duplicate values
             */
            if (
                    (0 < v && v <= N) &&
                            v != i + 1 &&
                            v != nums[v - 1]
            ) swap(nums, i, v - 1);
            else i++;
        }

        for (int j = 0; j < N; j++) {
            if (nums[j] != j + 1) return j + 1;
        }

        return N + 1;
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
