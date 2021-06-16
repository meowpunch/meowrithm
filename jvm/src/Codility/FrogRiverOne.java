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
        // Arrays.fill(leaves, false); // default is false

        // O(N)
        for (int i = 0; i < N; i++) {
            if (!leaves[A[i]]) {
                leaves[A[i]] = true;
                X -= 1;
                if (X == 0) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        boolean[] bArr = new boolean[10];
        int[] iArr = new int[10];

        System.out.println(bArr[0]);
        System.out.println(iArr[0]);
    }
}
