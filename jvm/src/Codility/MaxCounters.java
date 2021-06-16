package Codility;

import java.util.Arrays;

public class MaxCounters {
    // let the length of A be M
    //
    // * prerequisites
    //  N and M are integers within the range [1..100,000];
    //  each element of array A is an integer within the range [1..N + 1].
    //
    //
    public int[] solution(int N, int[] A) {
        final int M = A.length;

        int[] counters = new int[N];

        // 1 <= x <= N + 1
        int maxCounter = 0;
        for (int x: A) {
            if (x == N+1) {
                Arrays.fill(counters, maxCounter);
            } else {
                counters[x - 1] += 1;
                maxCounter = Math.max(maxCounter, counters[x - 1]);
            }
        }

        return counters;
    }
}
