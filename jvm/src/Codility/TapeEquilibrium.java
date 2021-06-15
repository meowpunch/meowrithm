package Codility;

public class TapeEquilibrium {
    /**
     *   let N be the length of A
     *   - N is an integer within the range [2..100,000];
     *   - each element of array A is an integer within the range [-1,000..1,000]
     */
    public int solution(int[] A) {

        long right = summation(A);
        long left = 0;
        long result = absolute(right);

        for (int a: A) {
            left += a;
            right -= a;

            final long diff = absolute(right - left);
            if (diff < result) result = diff;
            else break;
        }

        return (int) result;
    }


    private long summation(int[] A) {
        long result = 0;
        // aggreate elements
        for (int a: A) result += a;
        return result;
    }

    private long absolute(long a) {
        return a > 0? a: -a;
    }

    public static void main(String[] args) {

    }
}
