package codility;

public class MaxSliceSum {
    /**
     *  Time, Space: O(N), O(N)
     *  dp(i) is the maximum sum ending with the i-th element.
     *  dp(i) <- max(dp(i - 1), 0) + A(i))
     *  return max(dp)
     *
     *  on i step, we need only max sum ending with the i-1 element.
     *  Time, Space: O(N), O(1)
     */
    public int solution(int[] A) {
        int globalMax = -1000001;
        int localMax = -1000001;

        for (int a: A) {
            localMax = Math.max(localMax, 0) + a;
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
