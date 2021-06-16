package Codility;

public class TapeEquilibrium {
    /**
     *   let N be the length of A
     *   Any integer P, such that 0 < P < N, splits this tape into two non-empty parts
     *   - N is an integer within the range [2..100,000];
     *   - each element of array A is an integer within the range [-1,000..1,000]
     *
     *   Time/Space: O(N)/O(1)
     */
    public int solution(int[] A) {

        // init - O(N)
        long right = summation(A) - A[0];
        long left = A[0];
        long result = absolute(right - left);

        // dp - O(N)
        for (int p = 2; p < A.length; p++) {
            left += A[p - 1];
            right -= A[p - 1];

            final long diff = absolute(right - left);
            if (diff < result) result = diff;
        }

        return (int) result;
    }


    private long summation(int[] A) {
        long result = 0;
        // aggregate elements
        for (int a: A) result += a;
        return result;
    }

    private long absolute(long a) {
        return a > 0? a: -a;
    }

    public static void main(String[] args) {

    }
}
