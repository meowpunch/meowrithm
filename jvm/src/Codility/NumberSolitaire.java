package Codility;

public class NumberSolitaire {
    /**
     *  dp(i) is the maximal result on i-th.
     *  dp(i) = max(dp(j)) + f(i), i-6 <= j <= i-1
     *  return dp(N - 1)
     */
    public int solution(int[] A) {
        // 2 <= N <= 100,000
        final int N = A.length;
        int[] mem = new int[N];

        for (int i = 0; i < A.length; i++) {
            mem[i] = max(i, mem) + A[i];
        }

        return mem[N - 1];
    }

    // return maximum value of arr,  i-6 <= j <= i-1
    private int max(int i, int[] arr) {
        int max = Integer.MIN_VALUE;
        int j = Math.max(i - 6, 0);
        while (j < i) {
            max = Math.max(max, arr[j]);
            j++;
        }
        return i == 0? 0: max;
    }
}
