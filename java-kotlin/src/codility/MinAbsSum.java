package codility;

import java.util.Arrays;

public class MinAbsSum {
    /**
     * change input values
     *
     * -8 4 5 -10 3
     * -10 -8 3 4 5
     */
    public int solution(int[] A) {
        // sort
        Arrays.sort(A);

        // two pointers
        int left = 0; int right = A.length - 1;
        int minAbs = Integer.MAX_VALUE;

        while (left <= right) {
            minAbs = Math.min(minAbs, Math.abs(A[left] + A[right]));

            if (Math.abs(A[left]) < Math.abs(A[right])) right -= 1;
            else left += 1;
        }

        return minAbs;
    }
}
