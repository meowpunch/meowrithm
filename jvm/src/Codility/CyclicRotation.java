package Codility;

public class CyclicRotation {

    /**
     *   let the length of A be N
     *
     *   idx: 0, 1, 2, 3 ... i ... N-2, N-1
     *
     *   move i index element to (i + K) % N index
     *
     *   Time, Space: O(N), O(1)
     */
    public int[] solution(int[] A, int K) {
        final int N = A.length;
        if (N == 0) return A;

        K = K % N;
        if (K == 0) return A;

        int start = 0;
        int shiftCount = 0;
        while (shiftCount < N) {
            int currIdx = start;
            int currVal = A[currIdx];
            // do while
            do {
                int nextIdx = (currIdx + K) % N;
                int tempVal = A[nextIdx];

                // shift
                A[nextIdx] = currVal;
                currIdx = nextIdx;
                currVal = tempVal;
                shiftCount += 1;
            } while(start != currIdx);
            start += 1;
        }
        return A;
    }


    /**
     * easy way
     * Time, Space: O(N), O(N)
     */
    public  int[] solution1(int[] A, int K) {
        final int N = A.length;
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            final int next = (i + K) % N;
            result[next] = A[i];
        }

        return result;
    }

    /**
     *   Let the length of A be N
     *   If only correctness is focused, we solve the problem on time O(n^2) and space O(1)
     *
     */
    public int[] solution2(int[] A, int K) {
        final int N = A.length;

        if (N != 0) {
            // K times
            for (int k = 0; k < K; k++) {
                int tail = A[N - 1];
                // shift
                for (int i = N - 1; i > 0; i--) A[i] = A[i - 1];
                A[0] = tail;
            }
        }
        return A;
    }
}
