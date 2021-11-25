package codility;

import java.util.Arrays;

public class MaxCounters {
    // * prerequisites
    //  N and M are integers within the range [1..100,000];
    //  each element of array A is an integer within the range [1..N + 1].

    /**
     *  Time, Space: O(M+N), O(N)
     */
    public int[] solution(int N, int[] A) {
        // init
        int[] counts = new int[N];

        // let's count - O(M)
        int maxCount = 0;
        int startingLine = 0;
        for (int x: A) {
            if (x == N+1) {
                startingLine = maxCount;
            } else {
                counts[x - 1] = Math.max(counts[x - 1] + 1, startingLine + 1);
                maxCount = Math.max(maxCount, counts[x - 1]);
            }
        }

        // post adjust - O(N)
        for (int i = 0; i < N; i++) {
            counts[i] = Math.max(startingLine, counts[i]);
        }

        return counts;
    }


    //  Time, Space: O(n^2), O(n)
    public int[] solution2(int N, int[] A) {
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
