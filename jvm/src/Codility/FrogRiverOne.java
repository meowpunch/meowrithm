package Codility;

import java.util.Arrays;

public class FrogRiverOne {
    // N and X are integers within the range [1..100,000]
    // each element of array A is an integer within the range [1..X]
    //
    // Time, Space: O(N), O(N)
    public int solution(int X, int[] A) {
        final int N = A.length;
        if (N < X) return -1;

        // init
        boolean[] leaves = new boolean[X + 1];
        Arrays.fill(leaves, false);

        // O(N)
        int x = 0;
        for (int i = 0; i < N; i++) {
            if (!leaves[A[i]]) {
                leaves[A[i]] = true;
                x += 1;
                if (x == X) return i;
            }
        }

        return -1;
    }
}
