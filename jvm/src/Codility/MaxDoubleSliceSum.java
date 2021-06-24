package Codility;

public class MaxDoubleSliceSum {
    /**
     *
     *  dp(i) is that the maximal sum ending with i-th element
     *
     *  the double maximum slice = max(maximum starting with i - 1 + maximum ending with i + 1), 1 <= i <= N - 2
     *
     */
    public int solution(int[] A) {
        final int N = A.length;
        int max = Integer.MIN_VALUE;
        int[] maxEnding = new int[N];
        int[] maxStarting = new int[N];

        maxEnding[0] = 0;
        for (int i = 1; i < N; i++) maxEnding[i] = Math.max(maxEnding[i - 1], 0) + A[i];

        maxStarting[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--) maxStarting[i] = Math.max(maxStarting[i + 1], 0) + A[i];

        for (int i = 1; i < N - 1; i++) max = Math.max(maxEnding[i - 1] + maxStarting[i + 1], max);

        return max;
    }
}
